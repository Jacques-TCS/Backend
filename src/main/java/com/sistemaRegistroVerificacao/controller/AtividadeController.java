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
import com.sistemaRegistroVerificacao.model.entity.Atividade;
import com.sistemaRegistroVerificacao.model.repository.AtividadeRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/atividade")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class AtividadeController {
    
    @Autowired
    private AtividadeRepository atividadeRepository;

    @PostMapping
	public void salvar(@Valid @RequestBody Atividade novaAtividade) throws CampoInvalidoException {
		if(novaAtividade.getId() != null){
        	throw new CampoInvalidoException("id", "Para criar um novo registro, o ID não pode ser informado");
		}
        atividadeRepository.save(novaAtividade);
	}

	@GetMapping(path = "/{id}")
	public Optional<Atividade> consultarPorId(@PathVariable Integer id) {
		return atividadeRepository.findById(id);
	}

	@PutMapping
	public void atualizar(@Valid @RequestBody Atividade atividadeParaAtualizar) throws CampoInvalidoException {
		if(atividadeParaAtualizar.getId() == null){
        	throw new CampoInvalidoException("id", "É necessário informar o ID do registro");
		}
		Optional<Atividade> atividade = atividadeRepository.findById(atividadeParaAtualizar.getId());
		if(!atividade.isPresent()) {
			throw new CampoInvalidoException("id", "O ID informado não corresponde a nenhum registro");
		}
		atividadeRepository.save(atividadeParaAtualizar);
	}

	@GetMapping(path = "/todos")
	public List<Atividade> listarTodosAtividades() {
		return atividadeRepository.findAll();
	}
}
