package com.residencia.comercio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.comercio.dtos.CategoriaDTO;
import com.residencia.comercio.dtos.ProdutoDTO;
import com.residencia.comercio.entities.Categoria;
import com.residencia.comercio.entities.Produto;
import com.residencia.comercio.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;

	public List<Categoria> findAllCategoria() {
		return categoriaRepository.findAll();
	}

	public Categoria findCategoriaById(Integer id) {
		return categoriaRepository.findById(id).isPresent() ? categoriaRepository.findById(id).get() : null;
	}

	public Categoria saveCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public Categoria updateCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public void deleteCategoria(Integer id) {
		Categoria inst = categoriaRepository.findById(id).get();
		categoriaRepository.delete(inst);
	}

	public void deleteCategoria(Categoria categoria) {
		categoriaRepository.delete(categoria);
	}

	// DTO

	public CategoriaDTO findCategoriaDTOById(Integer id) {
		return categoriaRepository.findById(id).isPresent() ? converterParaDTO(categoriaRepository.findById(id).get())
				: null;
	}

	public Categoria saveCategoriaDTO(CategoriaDTO categoriaDTO) {
		Categoria categoria = converterParaEntidade(categoriaDTO);
		return categoriaRepository.save(categoria);
	}
	
	public Boolean findIfNomeCategoriaExists(String nomeCategoria) {
		Boolean categoriaExists = categoriaRepository.existsByNomeCategoria(nomeCategoria);
		return categoriaExists;
	}

	// CONVERSÃO

	public CategoriaDTO converterParaDTO(Categoria categoria) {
		CategoriaDTO categoraiDTO = new CategoriaDTO();
		categoraiDTO.setIdCategoria(categoria.getIdCategoria());
		categoraiDTO.setNomeCategoria(categoria.getNomeCategoria());

		return categoraiDTO;
	}

	public Categoria converterParaEntidade(CategoriaDTO categoriaDTO) {
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(categoriaDTO.getIdCategoria());
		categoria.setNomeCategoria(categoriaDTO.getNomeCategoria());

		return categoria;
	}

}
