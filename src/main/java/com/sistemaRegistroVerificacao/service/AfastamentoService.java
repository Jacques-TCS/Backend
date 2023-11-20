package com.sistemaRegistroVerificacao.service;

import java.time.LocalDate;
import java.util.List;

import com.sistemaRegistroVerificacao.exception.CampoInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.Afastamento;
import com.sistemaRegistroVerificacao.model.repository.AfastamentoRepository;
import com.sistemaRegistroVerificacao.model.seletor.AfastamentoSeletor;
import com.sistemaRegistroVerificacao.model.specification.AfastamentoSpecification;

@Service
public class AfastamentoService {

    @Autowired
    private AfastamentoRepository afastamentoRepository;

    public Afastamento inserir(Afastamento novoAfastamento) throws CampoInvalidoException {
        validarCamposObrigatorios(novoAfastamento);
        return afastamentoRepository.save(novoAfastamento);
    }

    public Afastamento atualizar(Afastamento afastamentoParaAtualizar) throws CampoInvalidoException {
        validarCamposObrigatorios(afastamentoParaAtualizar);
        return afastamentoRepository.save(afastamentoParaAtualizar);
    }

    private void validarCamposObrigatorios(Afastamento afastamento) throws CampoInvalidoException {
        String mensagemValidacao = "";

        mensagemValidacao += validarCampoString(afastamento.getNatureza(), "natureza");
        mensagemValidacao += validarCampoString(afastamento.getDescricao(), "descrição");
        mensagemValidacao += validarCampoData(afastamento.getDataInicio(), "data início", afastamento.getDataFim(), "data fim");

        if (!mensagemValidacao.isEmpty()) {
            throw new CampoInvalidoException(mensagemValidacao);
        }
    }

    private String validarCampoString(String valorCampo, String nomeCampo) {
        if (valorCampo == null || valorCampo.trim().isEmpty()) {
            return "Informe a " + nomeCampo + " do afastamento\n";
        }
        return "";
    }

    private String validarCampoData(LocalDate dataInicio, String nomeCampo, LocalDate dataFim, String nomeCampoFim) {
        if (dataInicio == null || dataFim == null) {
            return "Informe as datas de inicio e fim do afastamento\n";
        }
        return "";
    }

    public Afastamento consultarPorId(Integer id) {
        return afastamentoRepository.findById(id).get();
    }

    @Transactional
    public List<Afastamento> listarTodos() {
        return afastamentoRepository.findAll();
    }

    public List<Afastamento> listarComSeletor(AfastamentoSeletor seletor) {
        Specification<Afastamento> specification = AfastamentoSpecification.comFiltros(seletor);
        return afastamentoRepository.findAll(specification);
    }

    public boolean excluir(Integer id) {
        afastamentoRepository.deleteById(id);
        return true;
    }
}
