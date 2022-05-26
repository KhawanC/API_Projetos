package com.api.API_Estacionamento.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.API_Estacionamento.dtos.ParkingSpotDto;
import com.api.API_Estacionamento.models.ParkingSpotModel;
import com.api.API_Estacionamento.services.ParkingSpotService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/estacionamento-spot")
public class ParkingSpotController {
	
	final ParkingSpotService parkingSpotService;

	public ParkingSpotController(ParkingSpotService parkingSpotService) {
		this.parkingSpotService = parkingSpotService;
	}
	
	@PostMapping
	public ResponseEntity<Object> salvarEstacionamento(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {
		
		if(parkingSpotService.existsByPlacaVeiculo(parkingSpotDto.getPlacaVeiculo())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Essa placa já foi usada para uma vaga");	
		}
		if(parkingSpotService.existsByNumeroLugar(parkingSpotDto.getNumeroLugar())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Esse estacionamento já foi/está sendo usado");	
		}
		if(parkingSpotService.existsByApartamentoAndBloco(parkingSpotDto.getApartamento(), parkingSpotDto.getBloco())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Essa vaga já foi registrada nesse bloco/apartamento");	
		}
		
		var parkingSpotModel = new ParkingSpotModel();
		BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
		parkingSpotModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
	}
	
	@GetMapping
	public ResponseEntity<List<ParkingSpotModel>> getAllEstacionamentos() {
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneEstacionamento(@PathVariable(value = "id") UUID id) {
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
		if(!parkingSpotModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O estacionamento não foi encontrado");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
	}
}
