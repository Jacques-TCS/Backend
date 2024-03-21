package com.sistemaRegistroVerificacao.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.security.core.userdetails.UserDetails;

import com.sistemaRegistroVerificacao.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>, JpaSpecificationExecutor<Usuario> {
    
    /*
     * Esse método é utilizado pelo Spring Security para a autenticação do usuário
     */
    UserDetails findByUsername(String username);
}
