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

import com.residencia.academia.dto.AtividadeDTO;
import com.residencia.academia.entity.Atividade;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.AtividadeService;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {

	@Autowired
	AtividadeService atividadeService;

	@GetMapping
	public ResponseEntity<List<Atividade>> findAll() {
		List<Atividade> atividadeLista = atividadeService.findAll();
		return new ResponseEntity<>(atividadeLista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Atividade> findById(@PathVariable Integer id) {
		Atividade atividade = atividadeService.findById(id);
		if (null == atividade) {
			throw new NoSuchElementFoundException("GET - Não foi encontrado nenhuma atividade com o id " + id);
		} else {
			return new ResponseEntity<>(atividade, HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Atividade> post(@RequestBody Atividade atividade) {
		Atividade atividade2 = atividadeService.save(atividade);
		return new ResponseEntity<>(atividade2, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Atividade> put(@RequestBody Atividade atividade) {
		Atividade atividadeNew = atividadeService.save(atividade);
		return new ResponseEntity<>(atividadeNew, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		atividadeService.delete(id);
		return new ResponseEntity<>("", HttpStatus.OK);
	}

	// DTO

	@GetMapping("/dto/{id}")
	public ResponseEntity<AtividadeDTO> findAtividadeDTOById(@PathVariable Integer id) {
		AtividadeDTO atividadeDTO = atividadeService.findAtividadeDTOById(id);
		if (atividadeDTO == null) {
			throw new NoSuchElementFoundException("GET - Não foi possível encontrar a atividade com o id " + id);
		} else {
			return new ResponseEntity<>(atividadeDTO, HttpStatus.OK);
		}

	}

	@PostMapping("/dtoPost")
	public ResponseEntity<Atividade> saveInstrutorDTO(@RequestBody AtividadeDTO atividadeDTO) {
		Atividade atividadeNew = atividadeService.saveDTO(atividadeDTO);
		return new ResponseEntity<>(atividadeNew, HttpStatus.CREATED);
	}
}
