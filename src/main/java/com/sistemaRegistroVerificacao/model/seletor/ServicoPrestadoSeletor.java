package com.sistemaRegistroVerificacao.model.seletor;

import com.sistemaRegistroVerificacao.model.entity.Atividade;
import com.sistemaRegistroVerificacao.model.entity.Ocorrencia;
import com.sistemaRegistroVerificacao.model.entity.Sala;
import com.sistemaRegistroVerificacao.model.entity.Usuario;

import java.time.LocalDate;
import java.util.List;

public class ServicoPrestadoSeletor extends BaseSeletor {
    private String sala;
    private LocalDate dataHoraInicio;
    private LocalDate dataHoraFim;
    private List<Atividade> atividades;
    private List<Ocorrencia> ocorrencias;
    private String cargo;
    private String usuario;

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public LocalDate getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDate dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDate getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDate dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(List<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
