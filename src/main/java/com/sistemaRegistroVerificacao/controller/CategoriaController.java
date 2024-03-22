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
import com.sistemaRegistroVerificacao.model.entity.Categoria;
import com.sistemaRegistroVerificacao.model.entity.Categoria;
import com.sistemaRegistroVerificacao.model.repository.CategoriaRepository;
import com.sistemaRegistroVerificacao.model.seletor.CategoriaSeletor;
import com.sistemaRegistroVerificacao.service.CategoriaService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/categoria")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;

	    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
	public void salvar(@Valid @RequestBody Categoria novaCategoria) throws CampoInvalidoException {
		if(novaCategoria.getId() != null){
        	throw new CampoInvalidoException("id", "Para criar um novo registro, o ID não pode ser informado");
		}
        categoriaRepository.save(novaCategoria);
	}

	@GetMapping(path = "/{id}")
	public Optional<Categoria> consultarPorId(@PathVariable Integer id) {
		return categoriaRepository.findById(id);
	}

	@PutMapping
	public void atualizar(@Valid @RequestBody Categoria categoriaParaAtualizar) throws CampoInvalidoException {
		if(categoriaParaAtualizar.getId() == null){
			throw new CampoInvalidoException("id", "É necessário informar o ID do registro");
		}
		Optional<Categoria> categoria = categoriaRepository.findById(categoriaParaAtualizar.getId());
		if(!categoria.isPresent()) {
			throw new CampoInvalidoException("id", "O ID informado não corresponde a nenhum registro");
		}
		categoriaRepository.save(categoriaParaAtualizar);	
	}

	@GetMapping(path = "/todos")
	public List<Categoria> listarTodosCategorias() {
		return categoriaRepository.findAll();
	}

	@PostMapping("/filtro")
	public List<Categoria> listarComSeletor(@RequestBody CategoriaSeletor seletor) {
		return categoriaService.listarComSeletor(seletor);
	}
}
