package com.sistemaRegistroVerificacao.model.seletor;

import java.time.LocalDateTime;

public class UsuarioSeletor extends BaseSeletor {

	private String nome;
	private String cargo;
	private String statusUsuario;
	private LocalDateTime dataDesligamentoInicio;
	private LocalDateTime dataDesligamentoFim;

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

	public LocalDateTime getDataDesligamentoInicio() {
		return dataDesligamentoInicio;
	}

	public void setDataDesligamentoInicio(LocalDateTime dataDesligamentoInicio) {
		this.dataDesligamentoInicio = dataDesligamentoInicio;
	}

	public LocalDateTime getDataDesligamentoFim() {
		return dataDesligamentoFim;
	}

	public void setDataDesligamentoFim(LocalDateTime dataDesligamentoFim) {
		this.dataDesligamentoFim = dataDesligamentoFim;
	}

}
