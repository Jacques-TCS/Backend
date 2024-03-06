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
import com.sistemaRegistroVerificacao.model.entity.Usuario;
import com.sistemaRegistroVerificacao.model.entity.Usuario;
import com.sistemaRegistroVerificacao.model.repository.UsuarioRepository;
import com.sistemaRegistroVerificacao.model.repository.UsuarioRepository;
import com.sistemaRegistroVerificacao.model.seletor.UsuarioSeletor;
import com.sistemaRegistroVerificacao.service.UsuarioService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/usuario")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRepository usuarioRepository;

    @PostMapping
	public void salvar(@Valid @RequestBody Usuario novaUsuario) throws CampoInvalidoException {
		if(novaUsuario.getId() != null){
        	throw new CampoInvalidoException("id", "Para criar um novo registro, o ID não pode ser informado");
		}
        usuarioRepository.save(novaUsuario);
	}

	@GetMapping(path = "/{id}")
	public Optional<Usuario> consultarPorId(@PathVariable Integer id) {
		return usuarioRepository.findById(id);
	}

	@PutMapping
	public void atualizar(@Valid @RequestBody Usuario usuarioParaAtualizar) throws CampoInvalidoException {
		try {
			if(usuarioParaAtualizar.getId() == null){
				throw new CampoInvalidoException("id", "É necessário informar o ID do registro");
			}
			Optional<Usuario> usuario = usuarioRepository.findById(usuarioParaAtualizar.getId());
			if(!usuario.isPresent()) {
				throw new CampoInvalidoException("id", "O ID informado não corresponde a nenhum registro");
			}
			usuarioRepository.save(usuarioParaAtualizar);	
		} catch (EntityNotFoundException e) {
			throw new DataIntegrityViolationException(null);
		}
	}

	@GetMapping(path = "/todos")
	public List<Usuario> listarTodosUsuarios() {
		return usuarioRepository.findAll();
	}

	@PostMapping("/filtro")
	public List<Usuario> listarComSeletor(@RequestBody UsuarioSeletor seletor) {
		return usuarioService.listarComSeletor(seletor);
	}
}
