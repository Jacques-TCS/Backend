package com.sistemaRegistroVerificacao.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sistemaRegistroVerificacao.model.entity.NaturezaAfastamento;

public interface NaturezaAfastamentoRepository extends JpaRepository<NaturezaAfastamento, Integer>, JpaSpecificationExecutor<NaturezaAfastamento> {
}
