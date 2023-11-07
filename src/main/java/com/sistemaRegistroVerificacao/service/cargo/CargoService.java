package com.sistemaRegistroVerificacao.service.cargo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.cargo.Cargo;
import com.sistemaRegistroVerificacao.model.repository.cargo.CargoRepository;
import com.sistemaRegistroVerificacao.seletor.cargo.CargoSeletor;
import com.sistemaRegistroVerificacao.specification.cargo.CargoSpecification;

public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public Cargo inserir(Cargo novoCargo) {
        return cargoRepository.save(novoCargo);
    }

    public Cargo atualizar(Cargo cargoParaAtualizar) {
        return cargoRepository.save(cargoParaAtualizar);
    }

    public Cargo consultarPorId(Integer id) {
        return cargoRepository.findById(id).get();
    }

    @Transactional
    public List<Cargo> listarTodos() {
        return cargoRepository.findAll();
    }

    public List<Cargo> listarComSeletor(CargoSeletor seletor) {
        Specification<Cargo> specification = CargoSpecification.comFiltros(seletor);
        return cargoRepository.findAll(specification);
    }

    public boolean excluir(Integer id) {
        cargoRepository.deleteById(id);
        return true;
    }
}
