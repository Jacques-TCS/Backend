package com.sistemaRegistroVerificacao.controller;

import com.sistemaRegistroVerificacao.model.dto.AutenticacaoDTO;
import com.sistemaRegistroVerificacao.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AutenticacaoController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AutenticacaoDTO dto) {
        UsernamePasswordAuthenticationToken usernamePasswordToken =
                new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getSenha());
        Authentication auth = this.authenticationManager.authenticate(usernamePasswordToken);

        return ResponseEntity.ok().build();
    }
}
