package com.sistemaRegistroVerificacao.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sistemaRegistroVerificacao.model.entity.Afastamento;

public interface AfastamentoRepository extends JpaRepository<Afastamento, Integer>, JpaSpecificationExecutor<Afastamento> {
}

