package com.sistemaRegistroVerificacao.model.repository.nivelAcesso;

import com.sistemaRegistroVerificacao.model.entity.nivelAcesso.NivelAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NivelAcessoRepository extends JpaRepository<NivelAcesso, Long>, JpaSpecificationExecutor<NivelAcesso> {
}