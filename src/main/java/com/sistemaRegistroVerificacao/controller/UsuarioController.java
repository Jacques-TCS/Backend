package com.sistemaRegistroVerificacao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.sistemaRegistroVerificacao.model.repository.UsuarioRepository;
import com.sistemaRegistroVerificacao.model.seletor.UsuarioSeletor;
import com.sistemaRegistroVerificacao.service.UsuarioService;
import com.sistemaRegistroVerificacao.service.TokenService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/usuario")
public class UsuarioController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRepository usuarioRepository;

    @PostMapping
	public ResponseEntity salvar(@Valid @RequestBody Usuario novoUsuario) throws CampoInvalidoException {
        try{
            if(usuarioRepository.findByUsername(novoUsuario.getUsername()) != null){
                return ResponseEntity.badRequest().build();
            }

            String passwordCriptografada = new BCryptPasswordEncoder().encode(novoUsuario.getPassword());
            novoUsuario.setPassword(passwordCriptografada);
            usuarioRepository.save(novoUsuario);
            return ResponseEntity.ok().build();
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Erro ao criar usuário: " + e.getMessage());
        }
	}

	@Secured("ROLE_Gerente")
	@GetMapping(path = "/{id}")
	public Optional<Usuario> consultarPorId(@PathVariable Integer id) {
		return usuarioRepository.findById(id);
	}

	@Secured("ROLE_Gerente")
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

	@Secured("ROLE_Gerente")
	@GetMapping(path = "/todos")
	public List<Usuario> listarTodosUsuarios() {
		return usuarioRepository.findAll();
	}

	@Secured("ROLE_Gerente")
	@PostMapping("/filtro")
	public List<Usuario> listarComSeletor(@RequestBody UsuarioSeletor seletor) {
		return usuarioService.listarComSeletor(seletor);
	}

	@PostMapping("/login")
    public ResponseEntity login(@RequestBody Usuario usuario){
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            Usuario usuarioAutenticado = (Usuario) auth.getPrincipal();

            var token = tokenService.generateToken(usuarioAutenticado);

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            response.put("usuario", usuarioAutenticado.getNome());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
