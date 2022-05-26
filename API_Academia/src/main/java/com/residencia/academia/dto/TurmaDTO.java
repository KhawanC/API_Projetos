package com.residencia.academia.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.residencia.academia.entity.Atividade;
import com.residencia.academia.entity.Instrutor;

public class TurmaDTO {

	private Integer id;
	private LocalDateTime horario;
	private LocalTime duracao;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
	private Instrutor instrutor;
	private Atividade atividade;

	public Integer getId() {
		return id;
	}

	

	public LocalDateTime getHorario() {
		return horario;
	}



	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}



	public LocalTime getDuracao() {
		return duracao;
	}



	public void setDuracao(LocalTime duracao) {
		this.duracao = duracao;
	}



	public LocalDateTime getDataInicio() {
		return dataInicio;
	}



	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}



	public LocalDateTime getDataFim() {
		return dataFim;
	}



	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}



	public Instrutor getInstrutor() {
		return instrutor;
	}



	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}



	public Atividade getAtividade() {
		return atividade;
	}



	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "TurmaDTO [id=" + id + ", horario=" + horario + ", duracao=" + duracao + ", dataInicio=" + dataInicio
				+ ", dataFim=" + dataFim + ", instrutor=" + instrutor + ", atividade=" + atividade + "]";
	}

	

}
