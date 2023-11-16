package com.sistemaRegistroVerificacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.Afastamento;
import com.sistemaRegistroVerificacao.model.repository.AfastamentoRepository;
import com.sistemaRegistroVerificacao.seletor.AfastamentoSeletor;
import com.sistemaRegistroVerificacao.specification.AfastamentoSpecification;

@Service
public class AfastamentoService {

    @Autowired
    private AfastamentoRepository afastamentoRepository;

    public Afastamento inserir(Afastamento novoAfastamento) {
        return afastamentoRepository.save(novoAfastamento);
    }

    public Afastamento atualizar(Afastamento afastamentoParaAtualizar) {
        return afastamentoRepository.save(afastamentoParaAtualizar);
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
