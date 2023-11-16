package com.sistemaRegistroVerificacao.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sistemaRegistroVerificacao.model.entity.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Integer>, JpaSpecificationExecutor<Atividade> {
}

    
