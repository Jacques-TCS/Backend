package com.sistemaRegistroVerificacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.Atividade;
import com.sistemaRegistroVerificacao.model.repository.AtividadeRepository;
import com.sistemaRegistroVerificacao.model.seletor.AtividadeSeletor;
import com.sistemaRegistroVerificacao.model.specification.AtividadeSpecification;

public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public Atividade inserir(Atividade novaAtividade) {
        return atividadeRepository.save(novaAtividade);
    }

    public Atividade atualizar(Atividade atividadeParaAtualizar) {
        return atividadeRepository.save(atividadeParaAtualizar);
    }

    public Atividade consultarPorId(Integer id) {
        return atividadeRepository.findById(id).get();
    }

    @Transactional
    public List<Atividade> listarTodas() {
        return atividadeRepository.findAll();
    }

    public List<Atividade> listarComSeletor(AtividadeSeletor seletor) {
        Specification<Atividade> specification = AtividadeSpecification.comFiltros(seletor);
        return atividadeRepository.findAll(specification);
    }

    public boolean excluir(Integer id) {
        atividadeRepository.deleteById(id);
        return true;
    }
}
