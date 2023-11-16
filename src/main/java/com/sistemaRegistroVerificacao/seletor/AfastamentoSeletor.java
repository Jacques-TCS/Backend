package com.sistemaRegistroVerificacao.seletor;

import java.time.LocalDate;

public class AfastamentoSeletor extends BaseSeletor{
	
	private String natureza;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	
	public String getNatureza() {
		return natureza;
	}
	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
	
    
}
