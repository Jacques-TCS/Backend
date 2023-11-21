package com.sistemaRegistroVerificacao.model.entity;

//OBS: label é a descricao formatada
public enum StatusUsuario {
    ATIVO("Ativo"), INATIVO("Inativo"), AFASTADO("Afastado");

    public final String label;

    private StatusUsuario(String label) {
        this.label = label;
    }
}
