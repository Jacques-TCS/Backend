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

            if (seletor.getDescricao() != null){
                predicates.add((Predicate) cb.like(cb.lower(root.get("descricao")), "%" +  seletor.getDescricao().toLowerCase() + "%"));
            }

            if (seletor.getNatureza() != null){
                predicates.add((Predicate) cb.like(cb.lower(root.get("natureza")), "%" +  seletor.getNatureza().toLowerCase() + "%"));
            }

            if (seletor.getDataInicio() != null){
                predicates.add((Predicate) cb.like(cb.lower(root.get("dataInicio")), "%" +  seletor.getDataInicio() + "%"));
            }

            if (seletor.getDataFim() != null){
                predicates.add((Predicate) cb.like(cb.lower(root.get("dataFim")), "%" +  seletor.getDataFim() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
    
}
