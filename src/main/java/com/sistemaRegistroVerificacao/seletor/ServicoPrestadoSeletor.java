package com.sistemaRegistroVerificacao.seletor;

import java.time.LocalDate;

public class ServicoPrestadoSeletor extends BaseSeletor{
	
	private LocalDate dataHoraInicio;
	private LocalDate dataHoraFim;
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
    
}
