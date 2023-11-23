package com.sistemaRegistroVerificacao.model.seletor;

import java.time.LocalDate;

//No seletor ficam os atributos referentes ao que o usuário está inserindo no filtro
public class ServicoPrestadoSeletor extends BaseSeletor {
	private String sala;
	private LocalDate dataHoraInicio;
	private LocalDate dataHoraFim;
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
