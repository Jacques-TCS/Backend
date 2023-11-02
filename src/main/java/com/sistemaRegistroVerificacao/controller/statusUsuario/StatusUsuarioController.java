package com.sistemaRegistroVerificacao.controller.statusUsuario;
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
import com.sistemaRegistroVerificacao.model.entity.statusUsuario.StatusUsuario;
import com.sistemaRegistroVerificacao.seletor.statusUsuario.StatusUsuarioSeletor;
import com.sistemaRegistroVerificacao.service.statusUsuario.StatusUsuarioService;

@RestController
@RequestMapping(path = "/api/StatusUsuario")
public class StatusUsuarioController {
    
    @Autowired
    private StatusUsuarioService statusUsuarioService;

    @PostMapping
    public StatusUsuario salvar(@RequestBody StatusUsuario novoStatusUsuario) throws CampoInvalidoException {
        return statusUsuarioService.inserir(novoStatusUsuario);
    }

    @PutMapping
    public boolean atualizar(@RequestBody StatusUsuario statusUsuarioParaAtualizar) throws CampoInvalidoException {
        return statusUsuarioService.atualizar(statusUsuarioParaAtualizar) != null;
    }
    
    @GetMapping(path = "/{id}")
    public StatusUsuario consultarPorId(@PathVariable Integer id){
        return statusUsuarioService.consultarPorId(id);
    }

    @GetMapping(path = "/todos")
    public List<StatusUsuario> listarTodosStatusUsuarios() {
        return statusUsuarioService.listarTodos();
    }

    @PostMapping("/filtro")
	public List<StatusUsuario> listarComSeletor(@RequestBody StatusUsuarioSeletor seletor){
		return statusUsuarioService.listarComSeletor(seletor);
	}

    @DeleteMapping(path = "/{id}")
    public boolean excluir(@PathVariable Integer id) {
        return statusUsuarioService.excluir(id);
    }
}
