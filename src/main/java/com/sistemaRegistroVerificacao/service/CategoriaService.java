package com.sistemaRegistroVerificacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.exception.CampoInvalidoException;
import com.sistemaRegistroVerificacao.model.entity.Categoria;
import com.sistemaRegistroVerificacao.model.repository.CategoriaRepository;
import com.sistemaRegistroVerificacao.model.seletor.CategoriaSeletor;
import com.sistemaRegistroVerificacao.model.specification.CategoriaSpecification;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> listarComSeletor(CategoriaSeletor seletor) {
		Specification<Categoria> specification = CategoriaSpecification.comFiltros(seletor);
		return categoriaRepository.findAll(specification);
	}
}
