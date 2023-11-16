package com.sistemaRegistroVerificacao.model.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.Cargo;
import com.sistemaRegistroVerificacao.model.seletor.CargoSeletor;

public class CargoSpecification {

    public static Specification<Cargo> comFiltros(CargoSeletor seletor) {
        return null;
    }
    
}
