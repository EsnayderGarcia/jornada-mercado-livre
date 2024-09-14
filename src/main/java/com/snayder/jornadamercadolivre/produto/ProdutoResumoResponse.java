package com.snayder.jornadamercadolivre.produto;

import java.math.BigDecimal;

public record ProdutoResumoResponse(Long id, String nome, BigDecimal valor) {
    public ProdutoResumoResponse(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getValor());
    }
}
