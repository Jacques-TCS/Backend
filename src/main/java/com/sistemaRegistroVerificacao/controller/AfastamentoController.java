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
import com.sistemaRegistroVerificacao.model.entity.Afastamento;
import com.sistemaRegistroVerificacao.model.repository.AfastamentoRepository;
import com.sistemaRegistroVerificacao.model.seletor.AfastamentoSeletor;
import com.sistemaRegistroVerificacao.service.AfastamentoService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/afastamento")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class AfastamentoController {

	@Autowired
	private AfastamentoService afastamentoService;

	@Autowired
	private AfastamentoRepository afastamentoRepository;

    @PostMapping
	public void salvar(@Valid @RequestBody Afastamento novoAfastamento) throws CampoInvalidoException {
		if(novoAfastamento.getId() != null){
        	throw new CampoInvalidoException("id", "Para criar um novo registro, o ID não pode ser informado");
		}
        afastamentoRepository.save(novoAfastamento);
	}

	@GetMapping(path = "/{id}")
	public Optional<Afastamento> consultarPorId(@PathVariable Integer id) {
		return afastamentoRepository.findById(id);
	}

	@PutMapping
	public void atualizar(@Valid @RequestBody Afastamento afastamentoParaAtualizar) throws CampoInvalidoException {
		try {
			if(afastamentoParaAtualizar.getId() == null){
				throw new CampoInvalidoException("id", "É necessário informar o ID do registro");
			}
			Optional<Afastamento> afastamento = afastamentoRepository.findById(afastamentoParaAtualizar.getId());
			if(!afastamento.isPresent()) {
				throw new CampoInvalidoException("id", "O ID informado não corresponde a nenhum registro");
			}
			afastamentoRepository.save(afastamentoParaAtualizar);
		} catch (EntityNotFoundException e) {
			throw new DataIntegrityViolationException(null);
		}
	}

	@GetMapping(path = "/todos")
	public List<Afastamento> listarTodosAfastamentos() {
		return afastamentoRepository.findAll();
	}

	@PostMapping("/filtro")
	public List<Afastamento> listarComSeletor(@RequestBody AfastamentoSeletor seletor) {
		return afastamentoService.listarComSeletor(seletor);
	}
}
