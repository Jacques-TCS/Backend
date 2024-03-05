package com.sistemaRegistroVerificacao.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.sistemaRegistroVerificacao.exception.CampoInvalidoException;
import com.sistemaRegistroVerificacao.model.repository.OcorrenciaRepository;
import com.sistemaRegistroVerificacao.model.repository.ServicoPrestadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.Categoria;
import com.sistemaRegistroVerificacao.model.entity.Ocorrencia;
import com.sistemaRegistroVerificacao.model.entity.ServicoPrestado;
import com.sistemaRegistroVerificacao.model.seletor.OcorrenciaSeletor;
import com.sistemaRegistroVerificacao.model.specification.CategoriaSpecification;
import com.sistemaRegistroVerificacao.model.specification.OcorrenciaSpecification;

@Service
public class OcorrenciaService {

	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;

	public List<Ocorrencia> listarComSeletor(OcorrenciaSeletor seletor) {
		Specification<Ocorrencia> specification = OcorrenciaSpecification.comFiltros(seletor);
		return ocorrenciaRepository.findAll(specification);
	}
}
