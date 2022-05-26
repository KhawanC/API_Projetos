package com.residencia.academia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.InstrutorRepository;

@Service
public class InstrutorService {

	@Autowired
	InstrutorRepository instrutorRepository;

	public List<Instrutor> findAll() {
		return instrutorRepository.findAll();
	}

	public Instrutor findById(Integer id) {
		return instrutorRepository.findById(id).isPresent() ? instrutorRepository.findById(id).get() : null;
	}

	public Instrutor save(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}

	public Instrutor update(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}

	public void delete(Integer id) {
		Instrutor instrutor = instrutorRepository.findById(id).get();
		instrutorRepository.delete(instrutor);
	}

	// DTO
	public Instrutor saveDTO(InstrutorDTO instrutorDTO) {
		Instrutor instrutor = converterParaEntidade(instrutorDTO);
		return instrutorRepository.save(instrutor);
	}

	public InstrutorDTO findInstrutorDTOById(Integer id) {
		return instrutorRepository.findById(id).isPresent() ? converterParaDTO(instrutorRepository.findById(id).get())
				: null;
	}

	// CONVERSÕES
	private InstrutorDTO converterParaDTO(Instrutor instrutor) {
		InstrutorDTO instrutorDTO = new InstrutorDTO();
		instrutorDTO.setId(instrutor.getId());
		instrutorDTO.setNascimento(instrutor.getNascimento());
		instrutorDTO.setNome(instrutor.getNome());
		instrutorDTO.setRg(instrutor.getRg());

		List<TurmaDTO> listaTurmaDTO = new ArrayList<>();

		for (Turma turma : instrutor.getTurmaLista()) {
			TurmaDTO turmaDTO = new TurmaDTO();
			turmaDTO.setDataFim(turma.getDataFim());
			turmaDTO.setDataInicio(turma.getDataInicio());
			turmaDTO.setId(turma.getId());
			turmaDTO.setDuracao(turma.getDuracao());
			turmaDTO.setHorario(turma.getHorario());

			listaTurmaDTO.add(turmaDTO);
		}
		instrutorDTO.setTurmaDTOList(listaTurmaDTO);

		return instrutorDTO;
	}

	private Instrutor converterParaEntidade(InstrutorDTO instrutorDTO) {
		Instrutor instrutor = new Instrutor();
		instrutor.setId(instrutorDTO.getId());
		instrutor.setNascimento(instrutorDTO.getNascimento());
		instrutor.setNome(instrutorDTO.getNome());
		instrutor.setRg(instrutorDTO.getRg());

		return instrutor;
	}
}
