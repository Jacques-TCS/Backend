package com.sistemaRegistroVerificacao.specification.usuario;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.usuario.Usuario;
import com.sistemaRegistroVerificacao.seletor.usuario.UsuarioSeletor;

public class UsuarioSpecification {

    public static Specification<Usuario> comFiltros(UsuarioSeletor seletor) {
        return null;
    }
    
}
