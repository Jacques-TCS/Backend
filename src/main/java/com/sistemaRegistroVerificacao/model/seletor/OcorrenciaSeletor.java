package com.sistemaRegistroVerificacao.model.seletor;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaSeletor extends BaseSeletor {
	private String descricao;
	private String sala;
	private String categoria;
	private Boolean status;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
}
