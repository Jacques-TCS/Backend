package com.sistemaRegistroVerificacao.model.seletor;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//No seletor ficam os atributos referentes ao que o usuário está inserindo no filtro
public class ServicoPrestadoSeletor extends BaseSeletor {
	private String sala;
	private LocalDateTime menorDataHoraInicio;
	private LocalDateTime menorDataHoraFim;
	private LocalDateTime maiorDataHoraInicio;
	private LocalDateTime maiorDataHoraFim;
	private Integer ocorrencia;
	private String cargo;
	private String usuario;
	private String atividade;
}
