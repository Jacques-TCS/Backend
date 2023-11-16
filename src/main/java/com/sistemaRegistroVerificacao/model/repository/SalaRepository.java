package com.sistemaRegistroVerificacao.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sistemaRegistroVerificacao.model.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, Integer>, JpaSpecificationExecutor<Sala> {
}

