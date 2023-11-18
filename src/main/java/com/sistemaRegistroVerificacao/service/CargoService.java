package com.sistemaRegistroVerificacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.Cargo;
import com.sistemaRegistroVerificacao.model.repository.CargoRepository;

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
    
    public Cargo consultarPorDescricao(String descricao) {
        return cargoRepository.findByDescricao(descricao);
    }

    public boolean excluir(Integer id) {
        cargoRepository.deleteById(id);
        return true;
    }
}
