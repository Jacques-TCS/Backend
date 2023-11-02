package com.sistemaRegistroVerificacao.model.repository.atividade;

import com.sistemaRegistroVerificacao.model.entity.atividade.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AtividadeRepository extends JpaRepository<Atividade, Long>, JpaSpecificationExecutor<Atividade> {
}

    
