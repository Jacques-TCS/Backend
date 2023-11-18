package com.sistemaRegistroVerificacao.model.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.Atividade;
import com.sistemaRegistroVerificacao.model.seletor.AtividadeSeletor;

public class AtividadeSpecification {

    public static Specification<Atividade> comFiltros(AtividadeSeletor seletor) {
        return null;
    }
    
}
