package com.sistemaRegistroVerificacao.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sistemaRegistroVerificacao.model.entity.StatusUsuario;

public interface StatusUsuarioRepository extends JpaRepository<StatusUsuario, Integer>, JpaSpecificationExecutor<StatusUsuario> {
}

