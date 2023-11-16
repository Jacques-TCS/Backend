package com.sistemaRegistroVerificacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.StatusUsuario;
import com.sistemaRegistroVerificacao.model.repository.StatusUsuarioRepository;
import com.sistemaRegistroVerificacao.seletor.StatusUsuarioSeletor;
import com.sistemaRegistroVerificacao.specification.StatusUsuarioSpecification;

public class StatusUsuarioService {

    @Autowired
    private StatusUsuarioRepository statsUsuarioRepository;

    public StatusUsuario inserir(StatusUsuario novoStatusUsuario) {
        return statsUsuarioRepository.save(novoStatusUsuario);
    }

    public StatusUsuario atualizar(StatusUsuario statusUsuarioParaAtualizar) {
        return statsUsuarioRepository.save(statusUsuarioParaAtualizar);
    }

    public StatusUsuario consultarPorId(Integer id) {
        return statsUsuarioRepository.findById(id).get();
    }

    @Transactional
    public List<StatusUsuario> listarTodos() {
        return statsUsuarioRepository.findAll();
    }

    public List<StatusUsuario> listarComSeletor(StatusUsuarioSeletor seletor) {
        Specification<StatusUsuario> specification = StatusUsuarioSpecification.comFiltros(seletor);
        return statsUsuarioRepository.findAll(specification);
    }

    public boolean excluir(Integer id) {
        statsUsuarioRepository.deleteById(id);
        return true;
    }
}
