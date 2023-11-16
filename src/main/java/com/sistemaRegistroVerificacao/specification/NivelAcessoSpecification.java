package com.sistemaRegistroVerificacao.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sistemaRegistroVerificacao.model.entity.NivelAcesso;
import com.sistemaRegistroVerificacao.seletor.NivelAcessoSeletor;

public class NivelAcessoSpecification {

    public static Specification<NivelAcesso> comFiltros(NivelAcessoSeletor seletor) {
        return null;
    }
    
}
