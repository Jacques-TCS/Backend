package com.sistemaRegistroVerificacao.model.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.Sala;
import com.sistemaRegistroVerificacao.model.seletor.SalaSeletor;

public class SalaSpecification {

    public static Specification<Sala> comFiltros(SalaSeletor seletor) {
        return null;
    }
    
}
