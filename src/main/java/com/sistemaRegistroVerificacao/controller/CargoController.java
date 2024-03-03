package com.sistemaRegistroVerificacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaRegistroVerificacao.exception.CampoInvalidoException;
import com.sistemaRegistroVerificacao.model.entity.Cargo;
import com.sistemaRegistroVerificacao.model.entity.NivelAcesso;
import com.sistemaRegistroVerificacao.model.repository.CargoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/cargo")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class CargoController {
    
    @Autowired
    private CargoRepository cargoRepository;

    @PostMapping
	public void salvar(@Valid @RequestBody Cargo novoCargo) throws CampoInvalidoException {
		if(novoCargo.getId() != null){
        	throw new CampoInvalidoException("id", "Para criar um novo registro, o ID não pode ser informado");
		}
        cargoRepository.save(novoCargo);
	}

	@GetMapping(path = "/{id}")
	public Optional<Cargo> consultarPorId(@PathVariable Integer id) {
		return cargoRepository.findById(id);
	}

	@PutMapping
	public void atualizar(@Valid @RequestBody Cargo cargoParaAtualizar) throws CampoInvalidoException {
		if(cargoParaAtualizar.getId() == null){
        	throw new CampoInvalidoException("id", "É necessário informar o ID do registro");
		}
		Optional<Cargo> cargo = cargoRepository.findById(cargoParaAtualizar.getId());
		if(!cargo.isPresent()) {
			throw new CampoInvalidoException("id", "O ID informado não corresponde a nenhum registro");
		}
		cargoRepository.save(cargoParaAtualizar);
	}

	@GetMapping(path = "/todos")
	public List<Cargo> listarTodosCargos() {
		return cargoRepository.findAll();
	}
}
