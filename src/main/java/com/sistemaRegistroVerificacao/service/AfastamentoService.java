package com.sistemaRegistroVerificacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sistemaRegistroVerificacao.model.entity.Afastamento;
import com.sistemaRegistroVerificacao.model.repository.AfastamentoRepository;
import com.sistemaRegistroVerificacao.model.seletor.AfastamentoSeletor;
import com.sistemaRegistroVerificacao.model.specification.AfastamentoSpecification;

@Service
public class AfastamentoService {

	@Autowired
	private AfastamentoRepository afastamentoRepository;

	public List<Afastamento> listarComSeletor(AfastamentoSeletor seletor) {
		Specification<Afastamento> specification = AfastamentoSpecification.comFiltros(seletor);
		return afastamentoRepository.findAll(specification);
	}
}
