package com.sistemaRegistroVerificacao.model.seletor;

import java.time.LocalDate;

//No seletor ficam os atributos referentes ao que o usuário está inserindo no filtro
public class ServicoPrestadoSeletor extends BaseSeletor {

	private String sala;
	private LocalDate menorDataHoraInicio;
	private LocalDate menorDataHoraFim;
	private LocalDate maiorDataHoraInicio;
	private LocalDate maiorDataHoraFim;
	private Integer idTipoOcorrencia;
	private String cargo;
	private String usuario;
	private String atividade;

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public LocalDate getMenorDataHoraInicio() {
		return menorDataHoraInicio;
	}

	public void setMenorDataHoraInicio(LocalDate menorDataHoraInicio) {
		this.menorDataHoraInicio = menorDataHoraInicio;
	}

	public LocalDate getMenorDataHoraFim() {
		return menorDataHoraFim;
	}

	public void setMenorDataHoraFim(LocalDate menorDataHoraFim) {
		this.menorDataHoraFim = menorDataHoraFim;
	}

	public LocalDate getMaiorDataHoraInicio() {
		return maiorDataHoraInicio;
	}

	public void setMaiorDataHoraInicio(LocalDate maiorDataHoraInicio) {
		this.maiorDataHoraInicio = maiorDataHoraInicio;
	}

	public LocalDate getMaiorDataHoraFim() {
		return maiorDataHoraFim;
	}

	public void setMaiorDataHoraFim(LocalDate maiorDataHoraFim) {
		this.maiorDataHoraFim = maiorDataHoraFim;
	}

	public Integer getIdTipoOcorrencia() {
		return idTipoOcorrencia;
	}

	public void setIdTipoOcorrencia(Integer idTipoOcorrencia) {
		this.idTipoOcorrencia = idTipoOcorrencia;
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

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

}
