package com.snayder.jornadamercadolivre.produto;

import com.snayder.jornadamercadolivre.imagem.ImagemResponse;

import java.math.BigDecimal;

public record ProdutoResumoResponse(Long id, String nome, BigDecimal valor, ImagemResponse imagemPrincipal) {
    public ProdutoResumoResponse(Produto produto) {
        this(
            produto.getId(),
            produto.getNome(),
            produto.getValor(),
            produto.getImagemPrincipal().map(ImagemResponse::new).orElse(null)
        );
    }
}
