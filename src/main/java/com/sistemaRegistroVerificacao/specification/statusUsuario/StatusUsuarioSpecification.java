package com.sistemaRegistroVerificacao.specification.statusUsuario;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.statusUsuario.StatusUsuario;
import com.sistemaRegistroVerificacao.seletor.statusUsuario.StatusUsuarioSeletor;

public class StatusUsuarioSpecification {

    public static Specification<StatusUsuario> comFiltros(StatusUsuarioSeletor seletor) {
        return null;
    }
    
}
