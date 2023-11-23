package com.sistemaRegistroVerificacao.model.seletor;

import java.time.LocalDate;

public class AfastamentoSeletor extends BaseSeletor {

	private String descricao;
	private String natureza;
	private LocalDate menorDataInicio;
	private LocalDate maiorDataInicio;
	private LocalDate menorDataFim;
	private LocalDate maiorDataFim;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public LocalDate getMenorDataInicio() {
		return menorDataInicio;
	}

	public void setMenorDataInicio(LocalDate menorDataInicio) {
		this.menorDataInicio = menorDataInicio;
	}

	public LocalDate getmaiorDataInicio() {
		return maiorDataInicio;
	}

	public void setMaiorDataInicio(LocalDate maiorDataInicio) {
		this.maiorDataInicio = maiorDataInicio;
	}

	public LocalDate getMenorDataFim() {
		return menorDataFim;
	}

	public void setMenorDataFim(LocalDate menorDataFim) {
		this.menorDataFim = menorDataFim;
	}

	public LocalDate getMaiorDataFim() {
		return maiorDataFim;
	}

	public void setMaiorDataFim(LocalDate maiorDataFim) {
		this.maiorDataFim = maiorDataFim;
	}
}
