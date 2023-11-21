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
import com.sistemaRegistroVerificacao.model.entity.Sala;
import com.sistemaRegistroVerificacao.service.SalaService;

@RestController
@RequestMapping(path = "/api/sala")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class SalaController {
    
    @Autowired
    private SalaService salaService;

    @PostMapping
    public Sala salvar(@RequestBody Sala novaSala) throws CampoInvalidoException {
        return salaService.inserir(novaSala);
    }

    @PutMapping
    public boolean atualizar(@RequestBody Sala salaParaAtualizar) throws CampoInvalidoException {
        return salaService.atualizar(salaParaAtualizar) != null;
    }
    
    @GetMapping(path = "/{id}")
    public Sala consultarPorId(@PathVariable Integer id){
        return salaService.consultarPorId(id);
    }

    @GetMapping(path = "/todos")
    public List<Sala> listarTodasSalas() {
        return salaService.listarTodas();
    }

    @DeleteMapping(path = "/{id}")
    public boolean excluir(@PathVariable Integer id) {
        return salaService.excluir(id);
    }
}
