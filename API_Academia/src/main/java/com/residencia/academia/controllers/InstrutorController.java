package com.residencia.academia.controllers;

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

import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.InstrutorService;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

	@Autowired
	InstrutorService instrutorService;

	@GetMapping
	public ResponseEntity<List<Instrutor>> findAll() {
		List<Instrutor> instrutorLista = instrutorService.findAll();
		return new ResponseEntity<>(instrutorLista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Instrutor> findById(@PathVariable Integer id) {
		Instrutor instrutor = instrutorService.findById(id);
		if (null == instrutor) {
			throw new NoSuchElementFoundException("Não foi encontrado nenhuma turma com o id " + id);
		} else {
			return new ResponseEntity<>(instrutor, HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Instrutor> post(@RequestBody Instrutor instrutor) {
		Instrutor instrutor2 = instrutorService.save(instrutor);
		return new ResponseEntity<>(instrutor2, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Instrutor> put(@RequestBody Instrutor instrutor) {
		Instrutor instrutor2 = instrutorService.save(instrutor);
		return new ResponseEntity<>(instrutor2, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		instrutorService.delete(id);
		return new ResponseEntity<>("", HttpStatus.OK);
	}

	// DTO

	@GetMapping("/dto/{id}")
	public ResponseEntity<InstrutorDTO> findInstrutorDTOById(@PathVariable Integer id) {
		InstrutorDTO instrutorDTO = instrutorService.findInstrutorDTOById(id);
		if (instrutorDTO.getId() == null) {
			throw new NoSuchElementFoundException("GET - Não foi possível encontrar o instrutor com o id " + id);
		}

		
		else {
			return new ResponseEntity<>(instrutorDTO, HttpStatus.OK);
		}
	}

	@PostMapping("/dtoPost")
	public ResponseEntity<Instrutor> saveInstrutorDTO(@RequestBody InstrutorDTO instrutorDTO) {
		if(instrutorDTO.getRg().length() > 14) {
			throw new NoSuchElementFoundException("POST - Seu RG é muito longo, insira novamente");
		}
		else if(instrutorDTO.getRg().length() < 13){
			throw new NoSuchElementFoundException("POST - Seu RG é muito curto, insira novamente");
		}
		else {
			return new ResponseEntity<>(instrutorService.saveDTO(instrutorDTO), HttpStatus.OK);
		}
		
	}

}
