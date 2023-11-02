package com.sistemaRegistroVerificacao.model.repository.statusUsuario;

import com.sistemaRegistroVerificacao.model.entity.statusUsuario.StatusUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StatusUsuarioRepository extends JpaRepository<StatusUsuario, Long>, JpaSpecificationExecutor<StatusUsuario> {
}

