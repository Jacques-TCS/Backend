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
import com.sistemaRegistroVerificacao.model.entity.Ocorrencia;
import com.sistemaRegistroVerificacao.model.repository.OcorrenciaRepository;
import com.sistemaRegistroVerificacao.model.seletor.OcorrenciaSeletor;
import com.sistemaRegistroVerificacao.service.OcorrenciaService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/ocorrencia")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class OcorrenciaController {

	@Autowired
	private OcorrenciaService ocorrenciaService;

	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;

    @PostMapping
	public void salvar(@Valid @RequestBody Ocorrencia novaOcorrencia) throws CampoInvalidoException {
		if(novaOcorrencia.getId() != null){
        	throw new CampoInvalidoException("id", "Para criar um novo registro, o ID não pode ser informado");
		}
        ocorrenciaRepository.save(novaOcorrencia);
	}

	@GetMapping(path = "/{id}")
	public Optional<Ocorrencia> consultarPorId(@PathVariable Integer id) {
		return ocorrenciaRepository.findById(id);
	}

	@PutMapping
	public void atualizar(@Valid @RequestBody Ocorrencia ocorrenciaParaAtualizar) throws CampoInvalidoException {
		try {
			if(ocorrenciaParaAtualizar.getId() == null){
				throw new CampoInvalidoException("id", "É necessário informar o ID do registro");
			}
			Optional<Ocorrencia> ocorrencia = ocorrenciaRepository.findById(ocorrenciaParaAtualizar.getId());
			if(!ocorrencia.isPresent()) {
				throw new CampoInvalidoException("id", "O ID informado não corresponde a nenhum registro");
			}
			ocorrenciaRepository.save(ocorrenciaParaAtualizar);
		} catch (EntityNotFoundException e) {
			throw new DataIntegrityViolationException(null);
		}
	}

	@GetMapping(path = "/todos")
	public List<Ocorrencia> listarTodasOcorrencias() {
		return ocorrenciaRepository.findAll();
	}

	@PostMapping("/filtro")
	public List<Ocorrencia> listarComSeletor(@RequestBody OcorrenciaSeletor seletor) {
		return ocorrenciaService.listarComSeletor(seletor);
	}
}
