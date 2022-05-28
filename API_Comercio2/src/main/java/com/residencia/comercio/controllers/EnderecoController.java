package com.residencia.comercio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.comercio.dtos.EnderecoDTO;
import com.residencia.comercio.entities.Endereco;
import com.residencia.comercio.exceptions.NoSuchElementFoundException;
import com.residencia.comercio.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;

	@GetMapping
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> enderecoLista = enderecoService.findAllEnderecos();
		return new ResponseEntity<>(enderecoLista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Integer id) {
		Endereco Endereco = enderecoService.findEnderecoById(id);
		if (null == Endereco) {
			throw new NoSuchElementFoundException("GET - Não foi encontrado nenhum endereco com o id " + id);
		} else {
			return new ResponseEntity<>(Endereco, HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Endereco> saveEndereco(@RequestBody Endereco endereco) {
		if(endereco == null) {
			throw new NoSuchElementFoundException("Há um problema no body do seu JSON");
		}
		else {
			return new ResponseEntity<>(enderecoService.saveEndereco(endereco), HttpStatus.OK);
		}
	}

	// DTO
	
	@PostMapping("/dto")
	public ResponseEntity<Endereco> saveEnderecoDTO(@RequestBody EnderecoDTO enderecoDTO){
		if(enderecoDTO.getCep() == null || enderecoDTO.getCep().length() != 9) {
			throw new NoSuchElementFoundException("Há um erro no cep do seu JSON // " + enderecoDTO.toString());
		}
		else {
			return new ResponseEntity<>(enderecoService.saveEnderecoDTO(enderecoDTO), HttpStatus.OK);
		}
	}

}
