package com.residencia.firstapi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.firstapi.entity.Autor;
import com.residencia.firstapi.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;

	public List<Autor> findAll() {
		return autorRepository.findAll();
	}

	public Autor findById(Integer id) {
		return autorRepository.findById(id).get();
	}

	public Autor findByAutorNome(String nomeAutor) {
		return autorRepository.findByAutorNome(nomeAutor);
	}

	public List<Autor> findByAutorNomeStartsWith(String qualquerString) {
		return autorRepository.findByAutorNomeStartsWith(qualquerString);
	}

	public Autor save(Autor autor) {
		return autorRepository.save(autor);
	}

	public Autor update(Autor autor, Integer id) {
		return autorRepository.save(autor);
	}

	public void delete(Integer id) {
		Autor autor = autorRepository.findById(id).get();
		autorRepository.delete(autor);
	}
}
