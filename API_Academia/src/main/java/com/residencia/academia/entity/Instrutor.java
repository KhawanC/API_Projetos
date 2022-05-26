package com.residencia.academia.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Instrutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instrutorid")
	private Integer id;

	@Column(name = "rg")
	private String rg;

	@Column(name = "nome")
	private String nome;

	@Column(name = "nascimento")
	private LocalDateTime nascimento;

	@OneToMany(mappedBy = "instrutor")
	@JsonIgnore
	private List<Turma> turmaLista;

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

	public List<Turma> getTurmaLista() {
		return turmaLista;
	}

	public void setTurmaLista(List<Turma> turmaLista) {
		this.turmaLista = turmaLista;
	}

}
