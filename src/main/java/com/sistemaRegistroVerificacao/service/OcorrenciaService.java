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

	@Autowired
	private ServicoPrestadoRepository servicoPrestadoRepository;

	public Ocorrencia inserir(Ocorrencia novaOcorrencia) throws CampoInvalidoException {
		novaOcorrencia.setStatus(false);
		novaOcorrencia.setDataOcorrencia(LocalDateTime.now());
		validarCamposObrigatorios(novaOcorrencia);

		novaOcorrencia = ocorrenciaRepository.save(novaOcorrencia);

		ServicoPrestado servico = servicoPrestadoRepository.findById(novaOcorrencia.getServicoPrestado().getId()).get();
		servico.setOcorrencia(novaOcorrencia);

		// Atualiza a coluna IDOCORRENCIA em SERVICOPRESTADO
		servicoPrestadoRepository.save(servico);

		return novaOcorrencia;
	}

	public Ocorrencia atualizar(Ocorrencia ocorrenciaParaAtualizar) throws CampoInvalidoException {
		validarCamposObrigatorios(ocorrenciaParaAtualizar);
		return ocorrenciaRepository.save(ocorrenciaParaAtualizar);
	}

	private void validarCamposObrigatorios(Ocorrencia ocorrencia) throws CampoInvalidoException {
		String mensagemValidacao = "";

		mensagemValidacao += validarCampoString(ocorrencia.getDescricao(), "descricao");
		mensagemValidacao += validarCampoList(ocorrencia.getCategorias(), "categoria");
		mensagemValidacao += validarCampoBoolean(ocorrencia.isStatus(), "status");
		mensagemValidacao += validarCampoData(ocorrencia.getDataOcorrencia(), "dataOcorrencia");

		if (!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCampoList(Set<Categoria> categorias, String nomeCampo) {
		if (categorias == null || categorias.isEmpty()) {
			return "Informe ao menos 1 categoria \n";
		}
		return "";
	}

	private String validarCampoString(String valorCampo, String nomeCampo) {
		if (valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe a " + nomeCampo + " \n";
		}
		return "";
	}

	private String validarCampoBoolean(Boolean valorCampo, String nomeCampo) {
		if (valorCampo == null) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	private String validarCampoData(LocalDateTime dataOcorrencia, String nomeCampo) {
		if (dataOcorrencia == null) {
			return "Informe uma data \n";
		}
		return "";
	}

	public Ocorrencia consultarPorId(Integer id) {
		return ocorrenciaRepository.findById(id).get();
	}

	@Transactional
	public List<Ocorrencia> listarTodas() {
		return ocorrenciaRepository.findAll();
	}

	public List<Ocorrencia> listarComSeletor(OcorrenciaSeletor seletor) {
		Specification<Ocorrencia> specification = OcorrenciaSpecification.comFiltros(seletor);
		return ocorrenciaRepository.findAll(specification);
	}
}
