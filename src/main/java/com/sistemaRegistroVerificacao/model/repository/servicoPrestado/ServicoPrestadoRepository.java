package com.sistemaRegistroVerificacao.model.repository.servicoPrestado;

import com.sistemaRegistroVerificacao.model.entity.servicoPrestado.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer>, JpaSpecificationExecutor<ServicoPrestado> {
}
