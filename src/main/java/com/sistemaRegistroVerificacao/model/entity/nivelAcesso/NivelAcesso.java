package com.sistemaRegistroVerificacao.model.entity.nivelAcesso;

public enum NivelAcesso {
	FUNCIONARIO("Funcionário"), RH("Recursos Humanos"), GERENCIA("Gerencia");

	public final String label;

	private NivelAcesso(String label) {
		this.label = label;
	}
}
