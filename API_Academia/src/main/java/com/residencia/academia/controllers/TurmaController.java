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

import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {

	@Autowired
	TurmaService turmaService;

	@GetMapping
	public ResponseEntity<List<Turma>> listAll() {
		List<Turma> turmaLista = turmaService.listAll();
		return new ResponseEntity<>(turmaLista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> findById(@PathVariable Integer id) {
		Turma turma = turmaService.findById(id);
		if (null == turma) {
			throw new NoSuchElementFoundException("GET - Não foi encontrado nenhuma turma com o id " + id);
		} else {
			return new ResponseEntity<>(turma, HttpStatus.OK);
		}

	}

	@PostMapping
	public ResponseEntity<Turma> post(@RequestBody Turma turma) {
		Turma turma2 = turmaService.save(turma);
		return new ResponseEntity<>(turma2, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Turma> put(@RequestBody Turma turma) {
		Turma turma2 = turmaService.save(turma);
		return new ResponseEntity<>(turma2, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		Turma turma = turmaService.findById(id);
		if (null == turma) {
			return new ResponseEntity<>("", HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundException("DELETE - Não foi encontrado nenhuma turma com o id " + id);
		}
	}

	// DTO

	@GetMapping("/dto/{id}")
	public ResponseEntity<TurmaDTO> findTurmaDTOById(@PathVariable Integer id) {
		TurmaDTO turmaDTO = turmaService.findTurmaDTOById(id);
		if (turmaDTO == null) {
			throw new NoSuchElementFoundException("GET - Não foi possível encontrar a turma com o id " + id);
		} else {
			return new ResponseEntity<>(turmaDTO, HttpStatus.OK);
		}

	}

	@PostMapping("/dtoPost")
	public ResponseEntity<Turma> saveDTO(@RequestBody TurmaDTO turmaDTO) {
		if(turmaDTO.getDataInicio() != null || turmaDTO.getDataFim() != null) {
			throw new NoSuchElementFoundException("POST - Não é necessário/possível inserir a data inicio e a data fim");
		}
		else {
			return new ResponseEntity<>(turmaService.saveDTO(turmaDTO), HttpStatus.OK);
		}
		
	}

}
