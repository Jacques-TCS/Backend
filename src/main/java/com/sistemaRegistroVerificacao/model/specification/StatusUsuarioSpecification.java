package com.sistemaRegistroVerificacao.model.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.StatusUsuario;
import com.sistemaRegistroVerificacao.model.seletor.StatusUsuarioSeletor;

public class StatusUsuarioSpecification {

    public static Specification<StatusUsuario> comFiltros(StatusUsuarioSeletor seletor) {
        return null;
    }
    
}
