package com.sistemaRegistroVerificacao.model.seletor;

import java.time.LocalDate;

public class UsuarioSeletor extends BaseSeletor {

	private String nome;
	private String cargo;
	private String statusUsuario;
	private LocalDate dataDesligamentoInicio;
	private LocalDate dataDesligamentoFim;

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

	public LocalDate getDataDesligamentoInicio() {
		return dataDesligamentoInicio;
	}

	public void setDataDesligamentoInicio(LocalDate dataDesligamentoInicio) {
		this.dataDesligamentoInicio = dataDesligamentoInicio;
	}

	public LocalDate getDataDesligamentoFim() {
		return dataDesligamentoFim;
	}

	public void setDataDesligamentoFim(LocalDate dataDesligamentoFim) {
		this.dataDesligamentoFim = dataDesligamentoFim;
	}

}
