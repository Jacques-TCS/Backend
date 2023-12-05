package com.sistemaRegistroVerificacao.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sistemaRegistroVerificacao.model.entity.Atividade;
import com.sistemaRegistroVerificacao.model.entity.Sala;
import com.sistemaRegistroVerificacao.model.entity.ServicoPrestado;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer>, JpaSpecificationExecutor<ServicoPrestado> {
    List<ServicoPrestado> findByAtividades(Atividade atividade);
    List<ServicoPrestado> findBySala(Sala sala);
}
