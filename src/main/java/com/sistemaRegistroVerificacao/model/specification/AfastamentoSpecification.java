package com.sistemaRegistroVerificacao.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.Afastamento;
import com.sistemaRegistroVerificacao.model.seletor.AfastamentoSeletor;

import jakarta.persistence.criteria.Predicate;

public class AfastamentoSpecification {

	public static Specification<Afastamento> comFiltros(AfastamentoSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (seletor.getDescricao() != null) {
				predicates.add((Predicate) cb.like(cb.lower(root.get("descricao")),
						"%" + seletor.getDescricao().toLowerCase() + "%"));
			}

			if (seletor.getNatureza() != null) {
				predicates.add((Predicate) cb.like(cb.lower(root.get("natureza")),
						"%" + seletor.getNatureza().toLowerCase() + "%"));
			}

			if (seletor.getMenorDataInicio() != null && seletor.getMaiorDataInicio() != null) {
				// WHERE dataInicio BETWEEN min AND max
				predicates.add(
						cb.between(root.get("dataInicio"), seletor.getMenorDataInicio(), seletor.getMaiorDataInicio()));
			} else if (seletor.getMenorDataInicio() != null) {
				// WHERE dataInicio >= min
				predicates.add(cb.greaterThanOrEqualTo(root.get("dataInicio"), seletor.getMenorDataInicio()));
			} else if (seletor.getMaiorDataInicio() != null) {
				// WHERE dataInicio <= max
				predicates.add(cb.lessThanOrEqualTo(root.get("dataInicio"), seletor.getMaiorDataInicio()));
			}

			if (seletor.getMenorDataFim() != null && seletor.getMaiorDataFim() != null) {
				// WHERE dataFim BETWEEN min AND max
				predicates.add(cb.between(root.get("dataFim"), seletor.getMenorDataFim(), seletor.getMaiorDataFim()));
			} else if (seletor.getMenorDataFim() != null) {
				// WHERE dataFim >= min
				predicates.add(cb.greaterThanOrEqualTo(root.get("dataFim"), seletor.getMenorDataFim()));
			} else if (seletor.getMaiorDataFim() != null) {
				// WHERE dataFim <= max
				predicates.add(cb.lessThanOrEqualTo(root.get("dataFim"), seletor.getMaiorDataFim()));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
