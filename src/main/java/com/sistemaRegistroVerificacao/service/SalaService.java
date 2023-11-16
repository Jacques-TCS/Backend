package com.sistemaRegistroVerificacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.Sala;
import com.sistemaRegistroVerificacao.model.repository.SalaRepository;
import com.sistemaRegistroVerificacao.model.seletor.SalaSeletor;
import com.sistemaRegistroVerificacao.model.specification.SalaSpecification;

public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public Sala inserir(Sala novaSala) {
        return salaRepository.save(novaSala);
    }

    public Sala atualizar(Sala salaParaAtualizar) {
        return salaRepository.save(salaParaAtualizar);
    }

    public Sala consultarPorId(Integer id) {
        return salaRepository.findById(id).get();
    }

    @Transactional
    public List<Sala> listarTodas() {
        return salaRepository.findAll();
    }

    public List<Sala> listarComSeletor(SalaSeletor seletor) {
        Specification<Sala> specification = SalaSpecification.comFiltros(seletor);
        return salaRepository.findAll(specification);
    }

    public boolean excluir(Integer id) {
        salaRepository.deleteById(id);
        return true;
    }
}
