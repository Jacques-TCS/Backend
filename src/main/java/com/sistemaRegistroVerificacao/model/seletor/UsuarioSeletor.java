package com.sistemaRegistroVerificacao.model.seletor;

import com.sistemaRegistroVerificacao.model.entity.Afastamento;
import com.sistemaRegistroVerificacao.model.entity.Cargo;
import com.sistemaRegistroVerificacao.model.entity.NivelAcesso;
import com.sistemaRegistroVerificacao.model.entity.StatusUsuario;

import java.time.LocalDate;

public class UsuarioSeletor extends BaseSeletor {

    private String nome;
    private String cargo;
    private String statusUsuario;
    private LocalDate dataDesligamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(String statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento(LocalDate dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }
}
