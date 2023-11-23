package com.sistemaRegistroVerificacao.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.Categoria;
import com.sistemaRegistroVerificacao.model.seletor.CategoriaSeletor;

import jakarta.persistence.criteria.Predicate;

public class CategoriaSpecification {
	public static Specification<Categoria> comFiltros(CategoriaSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (seletor.getNome() != null) {
				predicates.add(
						(Predicate) cb.like(cb.lower(root.get("nome")), "%" + seletor.getNome().toLowerCase() + "%"));
			}

			if (seletor.getAtivo() != null) {
				predicates.add((Predicate) cb.equal(root.get("ativo"), seletor.getAtivo()));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
