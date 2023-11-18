package com.sistemaRegistroVerificacao.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.Ocorrencia;
import com.sistemaRegistroVerificacao.model.seletor.OcorrenciaSeletor;

public class OcorrenciaService {

    public Ocorrencia inserir(Ocorrencia novaOcorrencia) {
        return null;
    }

    public Ocorrencia atualizar(Ocorrencia ocorrenciaParaAtualizar) {
        return null;
    }

    public Ocorrencia consultarPorId(Integer id) {
        return null;
    }

    @Transactional
    public List<Ocorrencia> listarTodas() {
        return null;
    }

    public List<Ocorrencia> listarComSeletor(OcorrenciaSeletor seletor) {
        return null;
    }

    public boolean excluir(Integer id) {
        return false;
    }
}
