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
import com.sistemaRegistroVerificacao.model.entity.Ocorrencia;
import com.sistemaRegistroVerificacao.model.seletor.OcorrenciaSeletor;
import com.sistemaRegistroVerificacao.service.OcorrenciaService;

@RestController
@RequestMapping(path = "/api/ocorrencia")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class OcorrenciaController {

	@Autowired
	private OcorrenciaService ocorrenciaService;

	@PostMapping
	public Ocorrencia salvar(@RequestBody Ocorrencia novaOcorrencia) throws CampoInvalidoException {
		return ocorrenciaService.inserir(novaOcorrencia);
	}

	@PutMapping
	public boolean atualizar(@RequestBody Ocorrencia ocorrenciaParaAtualizar) throws CampoInvalidoException {
		return ocorrenciaService.atualizar(ocorrenciaParaAtualizar) != null;
	}

	@GetMapping(path = "/{id}")
	public Ocorrencia consultarPorId(@PathVariable Integer id) {
		return ocorrenciaService.consultarPorId(id);
	}

	@GetMapping(path = "/todos")
	public List<Ocorrencia> listarTodasOcorrencias() {
		return ocorrenciaService.listarTodas();
	}

	@PostMapping("/filtro")
	public List<Ocorrencia> listarComSeletor(@RequestBody OcorrenciaSeletor seletor) {
		return ocorrenciaService.listarComSeletor(seletor);
	}
}
