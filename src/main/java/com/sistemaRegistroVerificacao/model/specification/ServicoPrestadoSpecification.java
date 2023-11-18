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

            if (seletor.getDataHoraInicio() != null && seletor.getDataHoraFim() != null) {
//          TODO
                predicates.add(cb.between(root.get("dataHoraInicio"), seletor.getDataHoraInicio(),
                        seletor.getDataHoraFim()));
            } else if (seletor.getDataHoraInicio() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("dataHoraInicio"), seletor.getDataHoraInicio()));
            } else if (seletor.getDataHoraFim() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("dataHoraFim"), seletor.getDataHoraFim()));
            }

            //TODO
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
