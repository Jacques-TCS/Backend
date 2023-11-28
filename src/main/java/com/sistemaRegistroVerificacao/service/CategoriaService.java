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

	public Categoria inserir(Categoria novaCategoria) throws CampoInvalidoException {
		validarCamposObrigatorios(novaCategoria);
		novaCategoria.setAtivo(true);
		return categoriaRepository.save(novaCategoria);
	}

	public Categoria atualizar(Categoria categoriaParaAtualizar) throws CampoInvalidoException {
		validarCamposObrigatorios(categoriaParaAtualizar);
		return categoriaRepository.save(categoriaParaAtualizar);
	}

	private void validarCamposObrigatorios(Categoria categoria) throws CampoInvalidoException {
		String mensagemValidacao = "";

		mensagemValidacao += validarCampoString(categoria.getNome(), "nome");

		if (!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCampoString(String valorCampo, String nomeCampo) {
		if (valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe a " + nomeCampo + " \n";
		}
		return "";
	}

	public Categoria consultarPorId(Integer id) {
		return categoriaRepository.findById(id).get();
	}

	@Transactional
	public List<Categoria> listarTodas() {
		return categoriaRepository.findAll();
	}

	public List<Categoria> listarComSeletor(CategoriaSeletor seletor) {
		Specification<Categoria> specification = CategoriaSpecification.comFiltros(seletor);
		return categoriaRepository.findAll(specification);
	}
}
