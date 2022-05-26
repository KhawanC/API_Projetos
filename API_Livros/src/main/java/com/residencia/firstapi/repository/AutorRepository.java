package com.residencia.firstapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.firstapi.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

	Autor findByAutorNome(String autorNome);
	List<Autor> findByAutorNomeStartsWith(String qualquerString);
	
}