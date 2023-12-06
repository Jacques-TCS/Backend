package com.sistemaRegistroVerificacao.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.Usuario;
import com.sistemaRegistroVerificacao.model.seletor.UsuarioSeletor;

import jakarta.persistence.criteria.Predicate;

public class UsuarioSpecification {

	public static Specification<Usuario> comFiltros(UsuarioSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

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

			if (seletor.getCargo() != null) {
				predicates.add(cb.like(root.get("cargo"), "%" + seletor.getCargo() + "%"));
			}

			if (seletor.getStatusUsuario() != null) {
				predicates.add(cb.like(root.get("statusUsuario"), "%" + seletor.getStatusUsuario() + "%"));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
