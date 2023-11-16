package com.sistemaRegistroVerificacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.Usuario;
import com.sistemaRegistroVerificacao.model.repository.UsuarioRepository;
import com.sistemaRegistroVerificacao.model.seletor.UsuarioSeletor;
import com.sistemaRegistroVerificacao.model.specification.UsuarioSpecification;

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario inserir(Usuario novoUsuario) {
        return usuarioRepository.save(novoUsuario);
    }

    public Usuario atualizar(Usuario usuarioParaAtualizar) {
        return usuarioRepository.save(usuarioParaAtualizar);
    }

    public Usuario consultarPorId(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    @Transactional
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> listarComSeletor(UsuarioSeletor seletor) {
        Specification<Usuario> specification = UsuarioSpecification.comFiltros(seletor);
        return usuarioRepository.findAll(specification);
    }

    public boolean excluir(Integer id) {
        usuarioRepository.deleteById(id);
        return true;
    }
}
