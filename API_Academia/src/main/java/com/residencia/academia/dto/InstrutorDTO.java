package com.residencia.academia.dto;

import java.time.LocalDateTime;
import java.util.List;

public class InstrutorDTO {

	private Integer id;
	private String rg;
	private String nome;
	private LocalDateTime nascimento;
	private List<TurmaDTO> turmaDTOList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDateTime nascimento) {
		this.nascimento = nascimento;
	}

	public List<TurmaDTO> getTurmaDTOList() {
		return turmaDTOList;
	}

	public void setTurmaDTOList(List<TurmaDTO> turmaDTOList) {
		this.turmaDTOList = turmaDTOList;
	}

	@Override
	public String toString() {
		return "InstrutorDTO [id=" + id + ", rg=" + rg + ", nome=" + nome + ", nascimento=" + nascimento
				+ ", turmaDTOList=" + turmaDTOList + "]";
	}

}
