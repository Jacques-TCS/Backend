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
import com.sistemaRegistroVerificacao.model.entity.ServicoPrestado;
import com.sistemaRegistroVerificacao.model.entity.ServicoPrestado;
import com.sistemaRegistroVerificacao.model.repository.ServicoPrestadoRepository;
import com.sistemaRegistroVerificacao.model.seletor.ServicoPrestadoSeletor;
import com.sistemaRegistroVerificacao.service.ServicoPrestadoService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/servicoPrestado")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class ServicoPrestadoController {

	@Autowired
	private ServicoPrestadoService servicoPrestadoService;

    @Autowired
    private ServicoPrestadoRepository servicoPrestadoRepository;

	/*
	 * Ao salvar um registro de ServicoPrestado, é necessário pegar o usuário autenticado
	 * e inserir um novo registro na tabela ServicoPrestadoHistorico, para que assim seja
	 * registrado qual usuário deu início ao serviço.
	 */
    @PostMapping
	public void salvar(@Valid @RequestBody ServicoPrestado novoServicoPrestado) throws CampoInvalidoException {
		if(novoServicoPrestado.getId() != null){
        	throw new CampoInvalidoException("id", "Para criar um novo registro, o ID não pode ser informado");
		}
        servicoPrestadoRepository.save(novoServicoPrestado);
	}

	@GetMapping(path = "/{id}")
	public Optional<ServicoPrestado> consultarPorId(@PathVariable Integer id) {
		return servicoPrestadoRepository.findById(id);
	}

	@PutMapping
	public void atualizar(@Valid @RequestBody ServicoPrestado servicoPrestadoParaAtualizar) throws CampoInvalidoException {
		try {
			if(servicoPrestadoParaAtualizar.getId() == null){
				throw new CampoInvalidoException("id", "É necessário informar o ID do registro");
			}
			Optional<ServicoPrestado> servicoPrestado = servicoPrestadoRepository.findById(servicoPrestadoParaAtualizar.getId());
			if(!servicoPrestado.isPresent()) {
				throw new CampoInvalidoException("id", "O ID informado não corresponde a nenhum registro");
			}
			servicoPrestadoRepository.save(servicoPrestadoParaAtualizar);	
		} catch (EntityNotFoundException e) {
			throw new DataIntegrityViolationException(null);
		}
	}

	@GetMapping(path = "/todos")
	public List<ServicoPrestado> listarTodosServicoPrestados() {
		return servicoPrestadoRepository.findAll();
	}

	@PostMapping("/filtro")
	public List<ServicoPrestado> listarComSeletor(@RequestBody ServicoPrestadoSeletor seletor) {
		return servicoPrestadoService.listarComSeletor(seletor);
	}
}
