package com.sistemaRegistroVerificacao.model.repository.sala;

import com.sistemaRegistroVerificacao.model.entity.sala.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SalaRepository extends JpaRepository<Sala, Long>, JpaSpecificationExecutor<Sala> {
}

