package com.sistemaRegistroVerificacao.service.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.usuario.Usuario;
import com.sistemaRegistroVerificacao.model.repository.usuario.UsuarioRepository;
import com.sistemaRegistroVerificacao.seletor.usuario.UsuarioSeletor;
import com.sistemaRegistroVerificacao.specification.usuario.UsuarioSpecification;

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
