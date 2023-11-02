package com.sistemaRegistroVerificacao.controller.cargo;

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
import com.sistemaRegistroVerificacao.model.entity.cargo.Cargo;
import com.sistemaRegistroVerificacao.seletor.cargo.CargoSeletor;
import com.sistemaRegistroVerificacao.service.cargo.CargoService;

@RestController
@RequestMapping(path = "/api/cargo")
public class CargoController {
    
    @Autowired
    private CargoService cargoService;

    @PostMapping
    public Cargo salvar(@RequestBody Cargo novoCargo) throws CampoInvalidoException {
        return cargoService.inserir(novoCargo);
    }

    @PutMapping
    public boolean atualizar(@RequestBody Cargo cargoParaAtualizar) throws CampoInvalidoException {
        return cargoService.atualizar(cargoParaAtualizar) != null;
    }
    
    @GetMapping(path = "/{id}")
    public Cargo consultarPorId(@PathVariable Integer id){
        return cargoService.consultarPorId(id);
    }

    @GetMapping(path = "/todos")
    public List<Cargo> listarTodosCargos() {
        return cargoService.listarTodos();
    }

    @PostMapping("/filtro")
	public List<Cargo> listarComSeletor(@RequestBody CargoSeletor seletor){
		return cargoService.listarComSeletor(seletor);
	}

    @DeleteMapping(path = "/{id}")
    public boolean excluir(@PathVariable Integer id) {
        return cargoService.excluir(id);
    }
}