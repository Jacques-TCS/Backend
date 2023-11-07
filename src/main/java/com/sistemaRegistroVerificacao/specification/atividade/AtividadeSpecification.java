package com.sistemaRegistroVerificacao.specification.atividade;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.atividade.Atividade;
import com.sistemaRegistroVerificacao.seletor.atividade.AtividadeSeletor;

public class AtividadeSpecification {

    public static Specification<Atividade> comFiltros(AtividadeSeletor seletor) {
        return null;
    }
    
}
