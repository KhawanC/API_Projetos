package com.residencia.academia.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "atividadeid")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@OneToMany(mappedBy = "atividade")
	@JsonIgnore
	private List<Turma> turmaLista;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Turma> getTurmaLista() {
		return turmaLista;
	}

	public void setTurmaLista(List<Turma> turmaLista) {
		this.turmaLista = turmaLista;
	}

	

}
