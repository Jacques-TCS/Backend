package com.sistemaRegistroVerificacao.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.Usuario;
import com.sistemaRegistroVerificacao.seletor.UsuarioSeletor;

public class UsuarioSpecification {

    public static Specification<Usuario> comFiltros(UsuarioSeletor seletor) {
        return null;
    }
    
}
