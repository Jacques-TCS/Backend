package com.sistemaRegistroVerificacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.NivelAcesso;
import com.sistemaRegistroVerificacao.model.repository.NivelAcessoRepository;

public class NivelAcessoService {

    @Autowired
    private NivelAcessoRepository nivelAcessoRepository;

    public NivelAcesso inserir(NivelAcesso novoNivelAcesso) {
        return nivelAcessoRepository.save(novoNivelAcesso);
    }

    public NivelAcesso atualizar(NivelAcesso nivelAcessoParaAtualizar) {
        return nivelAcessoRepository.save(nivelAcessoParaAtualizar);
    }

    public NivelAcesso consultarPorId(Integer id) {
        return nivelAcessoRepository.findById(id).get();
    }

    @Transactional
    public List<NivelAcesso> listarTodos() {
        return nivelAcessoRepository.findAll();
    }

    public boolean excluir(Integer id) {
        nivelAcessoRepository.deleteById(id);
        return true;
    }
}
