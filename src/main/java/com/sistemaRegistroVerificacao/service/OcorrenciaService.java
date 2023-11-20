package com.sistemaRegistroVerificacao.service;

import java.time.LocalDate;
import java.util.List;

import com.sistemaRegistroVerificacao.exception.CampoInvalidoException;
import com.sistemaRegistroVerificacao.model.repository.OcorrenciaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.Ocorrencia;
import com.sistemaRegistroVerificacao.model.seletor.OcorrenciaSeletor;

public class OcorrenciaService {

    private OcorrenciaRepository ocorrenciaRepository;

    public Ocorrencia inserir(Ocorrencia novaOcorrencia) throws CampoInvalidoException {
        validarCamposObrigatorios(novaOcorrencia);
        return ocorrenciaRepository.save(novaOcorrencia);
    }

    public Ocorrencia atualizar(Ocorrencia ocorrenciaParaAtualizar) throws CampoInvalidoException {
        validarCamposObrigatorios(ocorrenciaParaAtualizar);
        return ocorrenciaRepository.save(ocorrenciaParaAtualizar);
    }

    private void validarCamposObrigatorios(Ocorrencia ocorrencia) throws CampoInvalidoException {
        String mensagemValidacao = "";

        mensagemValidacao += validarCampoString(ocorrencia.getDescricao(), "descrição");
        mensagemValidacao += validarCampoString(ocorrencia.getCategoria(), "categoria");
        mensagemValidacao += validarCampoBoolean(ocorrencia.isStatus(), "status");
        mensagemValidacao += validarCampoData(ocorrencia.getDataOcorrencia(), "data ocorrência");

        //TODO será que precisa validar isso?
        //private ServicoPrestado idServicoPrestado;

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

    //TODO Não tenho ctz se é assim a validação de um boolean
    private String validarCampoBoolean(Boolean valorCampo, String nomeCampo) {
        if (valorCampo == null) {
            return "Informe o " + nomeCampo + " \n";
        }
        return "";
    }

    private String validarCampoData(LocalDate dataOcorrencia, String nomeCampo) {
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
        return null;
    }

    public boolean excluir(Integer id) {
        ocorrenciaRepository.deleteById(id);
        return true;
    }
}
