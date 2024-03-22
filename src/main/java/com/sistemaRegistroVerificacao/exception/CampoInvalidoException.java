package com.sistemaRegistroVerificacao.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampoInvalidoException extends Exception {
    /*
     * Construtor padrão
     */
    public CampoInvalidoException(String mensagem) {
        super(mensagem);
    }

    private String campo;
    private String mensagemErro;
    /*
     * Construtor personalizado para informar o nome do campo com erro e a mensagem de erro correspondente
     * Ex:
     * nome |   mensagem
     * "id" : "Id inválido"
     */
    public CampoInvalidoException(String campo, String mensagemErro){
        this.campo = campo;
        this.mensagemErro = mensagemErro;
    }
}