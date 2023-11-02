package com.sistemaRegistroVerificacao.controller.nivelAcesso;
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
import com.sistemaRegistroVerificacao.model.entity.nivelAcesso.NivelAcesso;
import com.sistemaRegistroVerificacao.seletor.nivelAcesso.NivelAcessoSeletor;
import com.sistemaRegistroVerificacao.service.nivelAcesso.NivelAcessoService;

@RestController
@RequestMapping(path = "/api/nivelAcesso")
public class NivelAcessoController {
    
    @Autowired
    private NivelAcessoService nivelAcessoService;

    @PostMapping
    public NivelAcesso salvar(@RequestBody NivelAcesso novoNivelAcesso) throws CampoInvalidoException {
        return nivelAcessoService.inserir(novoNivelAcesso);
    }

    @PutMapping
    public boolean atualizar(@RequestBody NivelAcesso nivelAcessoParaAtualizar) throws CampoInvalidoException {
        return nivelAcessoService.atualizar(nivelAcessoParaAtualizar) != null;
    }
    
    @GetMapping(path = "/{id}")
    public NivelAcesso consultarPorId(@PathVariable Integer id){
        return nivelAcessoService.consultarPorId(id);
    }

    @GetMapping(path = "/todos")
    public List<NivelAcesso> listarTodosNivelAcessos() {
        return nivelAcessoService.listarTodos();
    }

    @PostMapping("/filtro")
	public List<NivelAcesso> listarComSeletor(@RequestBody NivelAcessoSeletor seletor){
		return nivelAcessoService.listarComSeletor(seletor);
	}

    @DeleteMapping(path = "/{id}")
    public boolean excluir(@PathVariable Integer id) {
        return nivelAcessoService.excluir(id);
    }
}
