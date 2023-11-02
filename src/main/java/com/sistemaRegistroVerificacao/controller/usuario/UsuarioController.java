package com.sistemaRegistroVerificacao.controller.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaRegistroVerificacao.exception.CampoInvalidoException;
import com.sistemaRegistroVerificacao.model.entity.usuario.Usuario;
import com.sistemaRegistroVerificacao.seletor.usuario.UsuarioSeletor;
import com.sistemaRegistroVerificacao.service.usuario.UsuarioService;

@RestController
@RequestMapping(path = "/api/usuario")
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
    public Usuario consultarPorId(@PathVariable Integer id){
        return usuarioService.consultarPorId(id);
    }

    @GetMapping(path = "/todos")
    public List<Usuario> listarTodosUsuarios() {
        return usuarioService.listarTodos();
    }

    @PostMapping("/filtro")
	public List<Usuario> listarComSeletor(@RequestBody UsuarioSeletor seletor){
		return UsuarioService.listarComSeletor(seletor);
	}

    @DeleteMapping(path = "/{id}")
    public boolean excluir(@PathVariable Integer id) {
        return usuarioService.excluir(id);
    }
}