package com.sistemaRegistroVerificacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.sistemaRegistroVerificacao.model.seletor.UsuarioSeletor;
import com.sistemaRegistroVerificacao.service.UsuarioService;

@RestController
@RequestMapping(path = "/api/usuario")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public Usuario salvar(@RequestBody Usuario novoUsuario) throws CampoInvalidoException {
		return usuarioService.inserir(novoUsuario);
	}

	@PutMapping
	public boolean atualizar(@RequestBody Usuario usuarioParaAtualizar) throws CampoInvalidoException {
		return usuarioService.atualizar(usuarioParaAtualizar) != null;
	}

	@GetMapping(path = "/{id}")
	public Usuario consultarPorId(@PathVariable Integer id) {
		return usuarioService.consultarPorId(id);
	}

	@GetMapping(path = "/todos")
	public List<Usuario> listarTodosUsuarios() {
		return usuarioService.listarTodos();
	}

	@PostMapping("/filtro")
	// public Page<Usuario> listarComSeletor(@RequestBody UsuarioSeletor seletor) {
	// return usuarioService.listarComSeletor(seletor);
	// }
	public List<Usuario> listarComSeletor(@RequestBody UsuarioSeletor seletor) {
		return usuarioService.listarComSeletor(seletor);
	}

	@GetMapping(path = "/cargos")
	public List<String> listarCargos() {
		return this.usuarioService.listarCargos();
	}

	@GetMapping(path = "/niveisAcesso")
	public List<String> listarNiveis() {
		return this.usuarioService.listarNiveis();
	}

	@GetMapping(path = "/status")
	public List<String> listarStatus() {
		return this.usuarioService.listarStatus();
	}
}
