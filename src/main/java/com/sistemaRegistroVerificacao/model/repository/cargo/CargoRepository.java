package com.sistemaRegistroVerificacao.model.repository.cargo;

import com.sistemaRegistroVerificacao.model.entity.cargo.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CargoRepository extends JpaRepository<Cargo, Long>, JpaSpecificationExecutor<Cargo> {
}

