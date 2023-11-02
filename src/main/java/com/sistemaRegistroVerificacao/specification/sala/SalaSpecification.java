package com.sistemaRegistroVerificacao.specification.sala;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.sala.Sala;
import com.sistemaRegistroVerificacao.seletor.sala.SalaSeletor;

public class SalaSpecification {

    public static Specification<Sala> comFiltros(SalaSeletor seletor) {
        return null;
    }
    
}
