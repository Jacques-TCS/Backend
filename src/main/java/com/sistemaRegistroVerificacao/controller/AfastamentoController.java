package com.sistemaRegistroVerificacao.controller;

import java.util.List;

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
import com.sistemaRegistroVerificacao.model.entity.Afastamento;
import com.sistemaRegistroVerificacao.model.seletor.AfastamentoSeletor;
import com.sistemaRegistroVerificacao.service.AfastamentoService;

@RestController
@RequestMapping(path = "/api/afastamento")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class AfastamentoController {

	@Autowired
	private AfastamentoService afastamentoService;

	@PostMapping
	public Afastamento salvar(@RequestBody Afastamento novoAfastamento) throws CampoInvalidoException {
		return afastamentoService.inserir(novoAfastamento);
	}

	@PutMapping
	public boolean atualizar(@RequestBody Afastamento afastamentoParaAtualizar) throws CampoInvalidoException {
		return afastamentoService.atualizar(afastamentoParaAtualizar) != null;
	}

	@GetMapping(path = "/{id}")
	public Afastamento consultarPorId(@PathVariable Integer id) {
		return afastamentoService.consultarPorId(id);
	}

	@GetMapping(path = "/todos")
	public List<Afastamento> listarTodosAfastamentos() {
		return afastamentoService.listarTodos();
	}

	@PostMapping("/filtro")
	public List<Afastamento> listarComSeletor(@RequestBody AfastamentoSeletor seletor) {
		return afastamentoService.listarComSeletor(seletor);
	}
}
