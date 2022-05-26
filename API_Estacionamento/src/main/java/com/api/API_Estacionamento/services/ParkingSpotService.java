package com.api.API_Estacionamento.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import com.api.API_Estacionamento.models.ParkingSpotModel;
import com.api.API_Estacionamento.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotService {
	
	final ParkingSpotRepository parkingSpotRepository;
	
	public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
		this.parkingSpotRepository = parkingSpotRepository;
	}

	@Transactional
	public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
		return parkingSpotRepository.save(parkingSpotModel);
	}

	public boolean existsByPlacaVeiculo(String placaVeiculo) {
		return parkingSpotRepository.existsByPlacaVeiculo(placaVeiculo);
	}

	public boolean existsByNumeroLugar(String numeroLugar) {
		return parkingSpotRepository.existsByNumeroLugar(numeroLugar);
	}

	public boolean existsByApartamentoAndBloco(String apartamento, String bloco) {
		return parkingSpotRepository.existsByApartamentoAndBloco(apartamento, bloco);
	}
	
	public List<ParkingSpotModel> findAll() {
		return parkingSpotRepository.findAll();
	}
	
	public Optional<ParkingSpotModel> findById(UUID id) {
		return parkingSpotRepository.findById(id);
	}
}
