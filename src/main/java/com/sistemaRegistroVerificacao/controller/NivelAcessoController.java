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
import com.sistemaRegistroVerificacao.model.entity.NivelAcesso;
import com.sistemaRegistroVerificacao.model.repository.NivelAcessoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/nivelAcesso")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class NivelAcessoController {
    
    @Autowired
    private NivelAcessoRepository nivelAcessoRepository;

    @PostMapping
	public void salvar(@Valid @RequestBody NivelAcesso novoNivelAcesso) throws CampoInvalidoException {
		if(novoNivelAcesso.getId() != null){
        	throw new CampoInvalidoException("id", "Para criar um novo registro, o ID não pode ser informado");
		}
        nivelAcessoRepository.save(novoNivelAcesso);
	}

	@GetMapping(path = "/{id}")
	public Optional<NivelAcesso> consultarPorId(@PathVariable Integer id) {
		return nivelAcessoRepository.findById(id);
	}

	@PutMapping
	public void atualizar(@Valid @RequestBody NivelAcesso nivelAcessoParaAtualizar) throws CampoInvalidoException {
		if(nivelAcessoParaAtualizar.getId() == null){
        	throw new CampoInvalidoException("id", "É necessário informar um ID válido para atualizar");
		}
		Optional<NivelAcesso> nivelAcesso = nivelAcessoRepository.findById(nivelAcessoParaAtualizar.getId());
		if(!nivelAcesso.isPresent()) {
			throw new CampoInvalidoException("id", "O ID informado não corresponde a nenhum registro");
		}
		nivelAcessoRepository.save(nivelAcessoParaAtualizar);
	}

	@GetMapping(path = "/todos")
	public List<NivelAcesso> listarTodosNivelAcessos() {
		return nivelAcessoRepository.findAll();
	}
}
