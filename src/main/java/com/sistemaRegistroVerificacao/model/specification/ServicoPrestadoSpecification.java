package com.sistemaRegistroVerificacao.model.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.ServicoPrestado;
import com.sistemaRegistroVerificacao.model.seletor.ServicoPrestadoSeletor;

public class ServicoPrestadoSpecification {

    public static Specification<ServicoPrestado> comFiltros(ServicoPrestadoSeletor seletor) {
        return null;
    }
    
}
