package com.sistemaRegistroVerificacao.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.Cargo;
import com.sistemaRegistroVerificacao.seletor.CargoSeletor;

public class CargoSpecification {

    public static Specification<Cargo> comFiltros(CargoSeletor seletor) {
        return null;
    }
    
}
