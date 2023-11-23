package com.sistemaRegistroVerificacao.model.seletor;

public class CategoriaSeletor extends BaseSeletor {

	private String nome;
	private Boolean ativo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
