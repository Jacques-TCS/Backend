package com.sistemaRegistroVerificacao.controller;
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
import com.sistemaRegistroVerificacao.model.entity.ServicoPrestado;
import com.sistemaRegistroVerificacao.model.seletor.ServicoPrestadoSeletor;
import com.sistemaRegistroVerificacao.service.ServicoPrestadoService;
@RestController
@RequestMapping(path = "/api/servicoPrestado")
public class ServicoPrestadoController {
    
    @Autowired
    private ServicoPrestadoService servicoPrestadoService;

    @PostMapping
    public ServicoPrestado salvar(@RequestBody ServicoPrestado novoServicoPrestado) throws CampoInvalidoException {
        return servicoPrestadoService.inserir(novoServicoPrestado);
    }
    
    @GetMapping(path = "/{id}")
    public ServicoPrestado consultarPorId(@PathVariable Integer id){
        return servicoPrestadoService.consultarPorId(id);
    }

    @GetMapping(path = "/todos")
    public List<ServicoPrestado> listarTodosServicoPrestados() {
        return servicoPrestadoService.listarTodos();
    }

    @PostMapping("/filtro")
	public List<ServicoPrestado> listarComSeletor(@RequestBody ServicoPrestadoSeletor seletor){
		return servicoPrestadoService.listarComSeletor(seletor);
	}
}
