package com.snayder.jornadamercadolivre.produto;

import com.snayder.jornadamercadolivre.caracteristica.CaracteristicaResponse;
import com.snayder.jornadamercadolivre.categoria.CategoriaResponse;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

public record ProdutoResponse(
    Long id,
    String nome,
    BigDecimal valor,
    Integer quantidade,
    Set<CaracteristicaResponse> caracteristicas,
    String descricao,
    CategoriaResponse categoria
) {
    public ProdutoResponse(Produto produto) {
        this(
            produto.getId(),
            produto.getNome(),
            produto.getValor(),
            produto.getQuantidade(),
            produto.getCaracteristicas().stream().map(CaracteristicaResponse::new).collect(Collectors.toSet()),
            produto.getDescricao(),
            new CategoriaResponse(produto.getCategoria())
        );
    }
}
