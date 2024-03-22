package com.sistemaRegistroVerificacao.service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

import com.sistemaRegistroVerificacao.exception.CampoInvalidoException;
import com.sistemaRegistroVerificacao.model.entity.Atividade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.ServicoPrestado;
import com.sistemaRegistroVerificacao.model.repository.ServicoPrestadoRepository;
import com.sistemaRegistroVerificacao.model.seletor.ServicoPrestadoSeletor;
import com.sistemaRegistroVerificacao.model.specification.ServicoPrestadoSpecification;

@Service
public class ServicoPrestadoService {

	@Autowired
	private ServicoPrestadoRepository servicoPrestadoRepository;

	public List<ServicoPrestado> listarComSeletor(ServicoPrestadoSeletor seletor) {
		Specification<ServicoPrestado> specification = ServicoPrestadoSpecification.comFiltros(seletor);
		return servicoPrestadoRepository.findAll(specification);
	}
}
