package com.sistemaRegistroVerificacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.Sala;
import com.sistemaRegistroVerificacao.model.repository.SalaRepository;

@Service
public class SalaService {

	@Autowired
	private SalaRepository salaRepository;

	public Sala inserir(Sala novaSala) {
		novaSala.setDisponivel(true);
		return salaRepository.save(novaSala);
	}

	public Sala atualizar(Sala salaParaAtualizar) {
		return salaRepository.save(salaParaAtualizar);
	}

	public Sala consultarPorId(Integer id) {
		return salaRepository.findById(id).get();
	}

	@Transactional
	public List<Sala> listarTodas() {
		return salaRepository.findAll();
	}
}
