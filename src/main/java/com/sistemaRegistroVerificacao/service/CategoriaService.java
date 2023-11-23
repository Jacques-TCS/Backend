package com.sistemaRegistroVerificacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.Categoria;
import com.sistemaRegistroVerificacao.model.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	// TODO Pensar se tem alguma validação de campo (exception)
	private CategoriaRepository categoriaRepository;

	public Categoria inserir(Categoria novaCategoria) {
		return categoriaRepository.save(novaCategoria);
	}

	public Categoria atualizar(Categoria categoriaParaAtualizar) {
		return categoriaRepository.save(categoriaParaAtualizar);
	}

	public Categoria consultarPorId(Integer id) {
		return categoriaRepository.findById(id).get();
	}

	@Transactional
	public List<Categoria> listarTodas() {
		return categoriaRepository.findAll();
	}

	public boolean excluir(Integer id) {
		categoriaRepository.deleteById(id);
		return true;
	}
}
