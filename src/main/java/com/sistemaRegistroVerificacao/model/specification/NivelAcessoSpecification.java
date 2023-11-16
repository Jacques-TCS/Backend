package com.sistemaRegistroVerificacao.model.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.NivelAcesso;
import com.sistemaRegistroVerificacao.model.seletor.NivelAcessoSeletor;

public class NivelAcessoSpecification {

    public static Specification<NivelAcesso> comFiltros(NivelAcessoSeletor seletor) {
        return null;
    }
    
}
