package com.snayder.jornadamercadolivre.caracteristica;

import com.snayder.jornadamercadolivre.produto.Produto;

public record CaracteristicaRequest(String nome, String descricao) {
    public Caracteristica toModel(Produto produto) {
        return new Caracteristica(nome, descricao, produto);
    }
}
