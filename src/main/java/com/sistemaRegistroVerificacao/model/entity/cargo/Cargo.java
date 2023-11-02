package com.sistemaRegistroVerificacao.model.entity.cargo;

public enum Cargo {
	FAXINA("Faxina"), ZELADORIA("Zeladoria"), TECNICO("Técnico"), RH("Recursos Humanos"), GERENCIA("Gerencia");

	public final String label;

	private Cargo(String label) {
		this.label = label;
	}
}
