package com.sistemaRegistroVerificacao.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sistemaRegistroVerificacao.model.entity.NivelAcesso;

public interface NivelAcessoRepository extends JpaRepository<NivelAcesso, Integer>, JpaSpecificationExecutor<NivelAcesso> {
}
