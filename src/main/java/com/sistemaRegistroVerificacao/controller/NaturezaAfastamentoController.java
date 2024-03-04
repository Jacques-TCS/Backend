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
import com.sistemaRegistroVerificacao.model.entity.NaturezaAfastamento;
import com.sistemaRegistroVerificacao.model.repository.NaturezaAfastamentoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/naturezaAfastamento")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class NaturezaAfastamentoController {

	@Autowired
	private NaturezaAfastamentoRepository naturezaRepository;

    @PostMapping
	public void salvar(@Valid @RequestBody NaturezaAfastamento novaNaturezaAfastamento) throws CampoInvalidoException {
		if(novaNaturezaAfastamento.getId() != null){
        	throw new CampoInvalidoException("id", "Para criar um novo registro, o ID não pode ser informado");
		}
        naturezaRepository.save(novaNaturezaAfastamento);
	}

	@GetMapping(path = "/{id}")
	public Optional<NaturezaAfastamento> consultarPorId(@PathVariable Integer id) {
		return naturezaRepository.findById(id);
	}

	@PutMapping
	public void atualizar(@Valid @RequestBody NaturezaAfastamento naturezaParaAtualizar) throws CampoInvalidoException {
		if(naturezaParaAtualizar.getId() == null){
        	throw new CampoInvalidoException("id", "É necessário informar o ID do registro");
		}
		Optional<NaturezaAfastamento> natureza = naturezaRepository.findById(naturezaParaAtualizar.getId());
		if(!natureza.isPresent()) {
			throw new CampoInvalidoException("id", "O ID informado não corresponde a nenhum registro");
		}
		naturezaRepository.save(naturezaParaAtualizar);
	}

	@GetMapping(path = "/todos")
	public List<NaturezaAfastamento> listarTodasNaturezaAfastamentos() {
		return naturezaRepository.findAll();
	}
}