package com.sistemaRegistroVerificacao.model.seletor;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AfastamentoSeletor extends BaseSeletor {
	private String descricao;
	private String natureza;
	private LocalDate menorDataInicio;
	private LocalDate maiorDataInicio;
	private LocalDate menorDataFim;
	private LocalDate maiorDataFim;
}
