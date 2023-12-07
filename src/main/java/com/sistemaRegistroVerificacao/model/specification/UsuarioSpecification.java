package com.sistemaRegistroVerificacao.model.specification;

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
			// WHERE nome like %Juliana%
			if (seletor.getNome() != null) {
				predicates.add(
						(Predicate) cb.like(cb.lower(root.get("nome")), "%" + seletor.getNome().toLowerCase() + "%"));
			}

			if (seletor.getDataDesligamentoInicio() != null && seletor.getDataDesligamentoFim() != null) {
                predicates.add(cb.between(root.get("dataDesligamento"), seletor.getDataDesligamentoInicio(),
                        seletor.getDataDesligamentoFim()));
            } else if (seletor.getDataDesligamentoInicio() != null) {
                predicates.add(
                        cb.greaterThanOrEqualTo(root.get("dataDesligamento"), seletor.getDataDesligamentoInicio()));
            } else if (seletor.getDataDesligamentoFim() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("dataDesligamento"), seletor.getDataDesligamentoFim()));
            }

			if (seletor.getStatusUsuario() != null && seletor.getStatusUsuario() != "") {
				predicates.add(cb.equal(root.get("statusUsuario"), seletor.getStatusUsuario()));
			}

			if (seletor.getCargo() != null && seletor.getCargo() != "") {
				predicates.add(cb.like(root.get("cargo"), "%" + seletor.getCargo() + "%"));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
