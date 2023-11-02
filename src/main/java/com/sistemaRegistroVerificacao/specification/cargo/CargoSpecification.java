package com.sistemaRegistroVerificacao.specification.cargo;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.cargo.Cargo;
import com.sistemaRegistroVerificacao.seletor.cargo.CargoSeletor;

public class CargoSpecification {

    public static Specification<Cargo> comFiltros(CargoSeletor seletor) {
        return null;
    }
    
}
