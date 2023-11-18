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

            // if (seletor.getRua() != null){
            //     predicates.add((Predicate) cb.like(cb.lower(root.get("rua")), "%" +  seletor.getRua().toLowerCase() + "%"));
            // }

            // if (seletor.getNumero() != null){
            //     predicates.add((Predicate) cb.like(cb.lower(root.get("numero")), "%" +  seletor.getNumero().toLowerCase() + "%"));
            // }

            // if (seletor.getBairro() != null){
            //     predicates.add((Predicate) cb.like(cb.lower(root.get("bairro")), "%" +  seletor.getBairro().toLowerCase() + "%"));
            // }

            // if (seletor.getCep() != null){
            //     predicates.add((Predicate) cb.like(cb.lower(root.get("cep")), "%" +  seletor.getCep().toLowerCase() + "%"));
            // }

            // if (seletor.getCidade() != null){
            //     predicates.add((Predicate) cb.like(cb.lower(root.get("cidade")), "%" +  seletor.getCidade().toLowerCase() + "%"));
            // }

            // if (seletor.getEstado() != null){
            //     predicates.add((Predicate) cb.like(cb.lower(root.get("estado")), "%" +  seletor.getEstado().toLowerCase() + "%"));
            // }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
    
}