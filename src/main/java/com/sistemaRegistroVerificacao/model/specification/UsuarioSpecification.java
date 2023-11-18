package com.sistemaRegistroVerificacao.model.specification;

import com.sistemaRegistroVerificacao.model.entity.Afastamento;
import com.sistemaRegistroVerificacao.model.seletor.AfastamentoSeletor;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.Usuario;
import com.sistemaRegistroVerificacao.model.seletor.UsuarioSeletor;

import java.util.ArrayList;
import java.util.List;

public class UsuarioSpecification {

    public static Specification<Usuario> comFiltros(UsuarioSeletor seletor) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // WHERE/AND COLUNA OPERADOR VALOR
            // WHERE      nome   like    %Juliana%
            if (seletor.getNome() != null) {
                predicates.add((Predicate) cb.like(cb.lower(root.get("nome")), "%" + seletor.getNome().toLowerCase() + "%"));
            }

            if (seletor.getDataDesligamento() != null) {
                predicates.add(cb.equal(root.get("dataDesligamento"), seletor.getDataDesligamento()));
            }

            if (seletor.getCargo() != null) {
                predicates.add(cb.equal(root.join("cargo").get("label"),
                        seletor.getCargo()));
            }

            if (seletor.getStatusUsuario() != null) {
                predicates.add(cb.equal(root.join("statusUsuario").get("label"),
                        seletor.getStatusUsuario()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
