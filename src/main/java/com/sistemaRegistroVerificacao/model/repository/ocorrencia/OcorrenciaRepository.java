package com.sistemaRegistroVerificacao.model.repository.ocorrencia;

import com.sistemaRegistroVerificacao.model.entity.ocorrencia.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long>, JpaSpecificationExecutor<Ocorrencia> {
}

