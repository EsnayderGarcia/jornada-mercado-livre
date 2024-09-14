package com.snayder.jornadamercadolivre.produto;

import com.snayder.jornadamercadolivre.caracteristica.CaracteristicaResponse;
import com.snayder.jornadamercadolivre.categoria.CategoriaResponse;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

public record ProdutoSalvoResponse(
   Long id,
   String nome,
   BigDecimal valor,
   Integer quantidade,
   String descricao,
   CategoriaResponse categoria,
   Set<CaracteristicaResponse> caracteristicas
) {
    public ProdutoSalvoResponse(Produto produto) {
        this(
            produto.getId(),
            produto.getNome(),
            produto.getValor(),
            produto.getQuantidade(),
            produto.getDescricao(),
            new CategoriaResponse(produto.getCategoria()),
            produto.getCaracteristicas().stream().map(CaracteristicaResponse::new).collect(Collectors.toSet())
        );
    }
}
