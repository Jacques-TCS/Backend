package com.sistemaRegistroVerificacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaRegistroVerificacao.exception.CampoInvalidoException;
import com.sistemaRegistroVerificacao.model.entity.Sala;
import com.sistemaRegistroVerificacao.model.entity.Sala;
import com.sistemaRegistroVerificacao.model.repository.SalaRepository;
import com.sistemaRegistroVerificacao.service.SalaService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/sala")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class SalaController {

	@Autowired
    private SalaRepository salaRepository;

    @PostMapping
	public void salvar(@Valid @RequestBody Sala novaSala) throws CampoInvalidoException {
		if(novaSala.getId() != null){
        	throw new CampoInvalidoException("id", "Para criar um novo registro, o ID não pode ser informado");
		}
        salaRepository.save(novaSala);
	}

	@GetMapping(path = "/{id}")
	public Optional<Sala> consultarPorId(@PathVariable Integer id) {
		return salaRepository.findById(id);
	}

	@PutMapping
	public void atualizar(@Valid @RequestBody Sala salaParaAtualizar) throws CampoInvalidoException {
		try {
			if(salaParaAtualizar.getId() == null){
				throw new CampoInvalidoException("id", "É necessário informar o ID do registro");
			}
			Optional<Sala> sala = salaRepository.findById(salaParaAtualizar.getId());
			if(!sala.isPresent()) {
				throw new CampoInvalidoException("id", "O ID informado não corresponde a nenhum registro");
			}
			salaRepository.save(salaParaAtualizar);	
		} catch (EntityNotFoundException e) {
			throw new DataIntegrityViolationException(null);
		}
	}

	@GetMapping(path = "/todos")
	public List<Sala> listarTodosSalas() {
		return salaRepository.findAll();
	}
}
