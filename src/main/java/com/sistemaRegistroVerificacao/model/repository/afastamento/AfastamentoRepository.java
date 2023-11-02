package com.sistemaRegistroVerificacao.model.repository.afastamento;

import com.sistemaRegistroVerificacao.model.entity.afastamento.Afastamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AfastamentoRepository extends JpaRepository<Afastamento, Long>, JpaSpecificationExecutor<Afastamento> {
}

