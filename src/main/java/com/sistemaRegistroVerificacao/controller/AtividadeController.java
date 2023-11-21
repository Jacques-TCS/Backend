package com.sistemaRegistroVerificacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaRegistroVerificacao.exception.CampoInvalidoException;
import com.sistemaRegistroVerificacao.model.entity.Atividade;
import com.sistemaRegistroVerificacao.service.AtividadeService;

@RestController
@RequestMapping(path = "/api/atividade")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class AtividadeController {
    
    @Autowired
    private AtividadeService atividadeService;

    @PostMapping
    public Atividade salvar(@RequestBody Atividade novoAtividade) throws CampoInvalidoException {
        return atividadeService.inserir(novoAtividade);
    }

    @PutMapping
    public boolean atualizar(@RequestBody Atividade atividadeParaAtualizar) throws CampoInvalidoException {
        return atividadeService.atualizar(atividadeParaAtualizar) != null;
    }
    
    @GetMapping(path = "/{id}")
    public Atividade consultarPorId(@PathVariable Integer id){
        return atividadeService.consultarPorId(id);
    }

    @GetMapping(path = "/todos")
    public List<Atividade> listarTodosAtividades() {
        return atividadeService.listarTodas();
    }

    @DeleteMapping(path = "/{id}")
    public boolean excluir(@PathVariable Integer id) {
        return atividadeService.excluir(id);
    }
}
