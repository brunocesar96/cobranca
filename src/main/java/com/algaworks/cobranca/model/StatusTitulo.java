package com.algaworks.cobranca.model;

/**
 * Created by bruno on 30/01/17.
 */
public enum StatusTitulo {

    PENDENTE("Pendente"),
    RECEBIDO("Recebido");

    private String descricao;

    StatusTitulo(String descricao){

        this.descricao=descricao;

    }

    public  String getDescricao(){

        return descricao;
    }

}
