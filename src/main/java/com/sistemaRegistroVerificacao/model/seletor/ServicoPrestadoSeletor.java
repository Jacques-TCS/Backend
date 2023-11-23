package com.sistemaRegistroVerificacao.model.seletor;

import java.time.LocalDateTime;

//No seletor ficam os atributos referentes ao que o usuário está inserindo no filtro
public class ServicoPrestadoSeletor extends BaseSeletor {

	private String sala;
	private LocalDateTime menorDataHoraInicio;
	private LocalDateTime menorDataHoraFim;
	private LocalDateTime maiorDataHoraInicio;
	private LocalDateTime maiorDataHoraFim;
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

	public LocalDateTime getMenorDataHoraInicio() {
		return menorDataHoraInicio;
	}

	public void setMenorDataHoraInicio(LocalDateTime menorDataHoraInicio) {
		this.menorDataHoraInicio = menorDataHoraInicio;
	}

	public LocalDateTime getMenorDataHoraFim() {
		return menorDataHoraFim;
	}

	public void setMenorDataHoraFim(LocalDateTime menorDataHoraFim) {
		this.menorDataHoraFim = menorDataHoraFim;
	}

	public LocalDateTime getMaiorDataHoraInicio() {
		return maiorDataHoraInicio;
	}

	public void setMaiorDataHoraInicio(LocalDateTime maiorDataHoraInicio) {
		this.maiorDataHoraInicio = maiorDataHoraInicio;
	}

	public LocalDateTime getMaiorDataHoraFim() {
		return maiorDataHoraFim;
	}

	public void setMaiorDataHoraFim(LocalDateTime maiorDataHoraFim) {
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
