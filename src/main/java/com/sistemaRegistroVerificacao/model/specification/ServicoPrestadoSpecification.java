package com.sistemaRegistroVerificacao.model.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.ServicoPrestado;
import com.sistemaRegistroVerificacao.model.seletor.ServicoPrestadoSeletor;

import java.util.ArrayList;
import java.util.List;

public class ServicoPrestadoSpecification {

    public static Specification<ServicoPrestado> comFiltros(ServicoPrestadoSeletor seletor) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (seletor.getSala() != null) {
                predicates.add(cb.like(root.join("sala").get("numero"),
                        "%" + seletor.getSala() + "%"));
            }

            if (seletor.getMenorDataHoraInicio() != null && seletor.getMenorDataHoraFim() != null) {
                predicates.add(cb.between(root.get("menorDataHoraInicio"), seletor.getMenorDataHoraInicio(),
                        seletor.getMenorDataHoraFim()));
            } else if (seletor.getMenorDataHoraInicio() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("menorDataHoraInicio"), seletor.getMenorDataHoraInicio()));
            } else if (seletor.getMenorDataHoraFim() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("menorDataHoraFim"), seletor.getMenorDataHoraFim()));
            }

            if (seletor.getMaiorDataHoraInicio() != null && seletor.getMaiorDataHoraFim() != null) {
                predicates.add(cb.between(root.get("maiorDataHoraInicio"), seletor.getMaiorDataHoraInicio(),
                        seletor.getMaiorDataHoraFim()));
            } else if (seletor.getMaiorDataHoraInicio() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("maiorDataHoraInicio"), seletor.getMaiorDataHoraInicio()));
            } else if (seletor.getMaiorDataHoraFim() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("maiorDataHoraFim"), seletor.getMaiorDataHoraFim()));
            }

            if (seletor.getIdTipoOcorrencia() != null) {
                predicates.add(cb.equal(root.join("ocorrencias").get("id"), seletor.getIdTipoOcorrencia()));
            }

            if (seletor.getCargo() != null) {
                predicates.add(cb.like(root.join("cargo").get("label"),
                        "%" + seletor.getCargo() + "%"));
            }

            if (seletor.getUsuario() != null) {
                predicates.add(cb.like(root.join("usuario").get("nome"), "%" +
                        seletor.getUsuario().toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
