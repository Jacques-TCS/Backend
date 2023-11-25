package com.sistemaRegistroVerificacao.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.Ocorrencia;
import com.sistemaRegistroVerificacao.model.seletor.OcorrenciaSeletor;

import jakarta.persistence.criteria.Predicate;

public class OcorrenciaSpecification {
	public static Specification<Ocorrencia> comFiltros(OcorrenciaSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (seletor.getDescricao() != null && !seletor.getDescricao().isEmpty()) {
				predicates.add((Predicate) cb.like(cb.lower(root.get("descricao")),
						"%" + seletor.getDescricao().toLowerCase() + "%"));
			}

			if (seletor.getSala() != null && !seletor.getSala().isEmpty()) {
				predicates.add((Predicate) cb.like(cb.lower(root.join("servicoPrestado").get("sala").get("numero")),
						"%" + seletor.getSala().toLowerCase() + "%"));
			}

			if (seletor.getCategoria() != null) {
				predicates.add((Predicate) cb.like(cb.lower(root.join("categoria").get("nome")),
						"%" + seletor.getCategoria().toLowerCase() + "%"));
			}

			if (seletor.getStatus() != null) {
				predicates.add((Predicate) cb.equal(root.get("status"), seletor.getStatus()));
			}

			if (seletor.getDataInicio() != null && seletor.getDataFim() != null) {
				// WHERE dataOcorrencia BETWEEN min AND max
				predicates.add(cb.between(root.get("dataOcorrencia"), seletor.getDataInicio(), seletor.getDataFim()));
			} else if (seletor.getDataInicio() != null) {
				// WHERE dataOcorrencia >= min
				predicates.add(cb.greaterThanOrEqualTo(root.get("dataOcorrencia"), seletor.getDataInicio()));
			} else if (seletor.getDataFim() != null) {
				// WHERE dataOcorrencia <= max
				predicates.add(cb.lessThanOrEqualTo(root.get("dataOcorrencia"), seletor.getDataFim()));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
