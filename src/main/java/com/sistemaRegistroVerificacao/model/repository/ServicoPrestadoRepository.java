package com.sistemaRegistroVerificacao.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sistemaRegistroVerificacao.model.entity.ServicoPrestado;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer>, JpaSpecificationExecutor<ServicoPrestado> {
}
