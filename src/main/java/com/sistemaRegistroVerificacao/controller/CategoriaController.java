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
import com.sistemaRegistroVerificacao.model.entity.Categoria;
import com.sistemaRegistroVerificacao.model.seletor.CategoriaSeletor;
import com.sistemaRegistroVerificacao.service.CategoriaService;

@RestController
@RequestMapping(path = "/api/categoria")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;

	@PostMapping
	public Categoria salvar(@RequestBody Categoria novoCategoria) throws CampoInvalidoException {
		return categoriaService.inserir(novoCategoria);
	}

	@PutMapping
	public boolean atualizar(@RequestBody Categoria categoriaParaAtualizar) throws CampoInvalidoException {
		return categoriaService.atualizar(categoriaParaAtualizar) != null;
	}

	@GetMapping(path = "/{id}")
	public Categoria consultarPorId(@PathVariable Integer id) {
		return categoriaService.consultarPorId(id);
	}

	@GetMapping(path = "/todos")
	public List<Categoria> listarTodosCategoria() {
		return categoriaService.listarTodas();
	}

	@PostMapping("/filtro")
	public List<Categoria> listarComSeletor(@RequestBody CategoriaSeletor seletor) {
		return categoriaService.listarComSeletor(seletor);
	}
}
