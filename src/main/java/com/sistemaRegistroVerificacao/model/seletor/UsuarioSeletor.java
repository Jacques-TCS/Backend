package com.sistemaRegistroVerificacao.model.seletor;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioSeletor extends BaseSeletor {
	private String nome;
	private String cargo;
	private String statusUsuario;
	private LocalDate dataDesligamentoInicio;
	private LocalDate dataDesligamentoFim;
}
