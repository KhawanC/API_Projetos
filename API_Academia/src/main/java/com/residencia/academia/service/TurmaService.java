package com.residencia.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository turmaRepository;

	public List<Turma> listAll() {
		return turmaRepository.findAll();
	}

	public Turma findById(Integer turmaId) {
		return turmaRepository.findById(turmaId).isPresent() ? turmaRepository.findById(turmaId).get() : null;
	}

	public Turma save(Turma turma) {
		return turmaRepository.save(turma);
	}

	public Turma update(Turma turma) {
		return turmaRepository.save(turma);
	}

	public void delete(Integer instrutorId) {
		turmaRepository.deleteById(instrutorId);
	}
	
	//DTO
	
	public TurmaDTO findTurmaDTOById(Integer id) {
		return turmaRepository.findById(id).isPresent() ? converterParaDTO(turmaRepository.findById(id).get()) : null;
	}
	
	public Turma saveDTO(TurmaDTO turmaDTO) {
		Turma turma = converterParaTurma(turmaDTO);
		return turmaRepository.save(turma);
	}
	
	//CONVERSAO
	public TurmaDTO converterParaDTO(Turma turma) {
		TurmaDTO turmaDTO = new TurmaDTO();
		turmaDTO.setId(turma.getId());
		turmaDTO.setHorario(turma.getHorario());
		turmaDTO.setDuracao(turma.getDuracao());
		turmaDTO.setDataInicio(turma.getDataInicio());
		turmaDTO.setDataFim(turma.getDataFim());
		turmaDTO.setInstrutor(turma.getInstrutor());
		turmaDTO.setAtividade(turma.getAtividade());		
		
		return turmaDTO;
	}
	
	public Turma converterParaTurma(TurmaDTO turmaDTO) {
		Turma turma = new Turma();
		turma.setId(turmaDTO.getId());
		turma.setHorario(turmaDTO.getHorario());
		turma.setDuracao(turmaDTO.getDuracao());
		turma.setDataInicio(turmaDTO.getDataInicio());
		turma.setDataFim(turmaDTO.getDataFim());
		turma.setInstrutor(turmaDTO.getInstrutor());
		turma.setAtividade(turmaDTO.getAtividade());		
		
		return turma;
	}
	
}
