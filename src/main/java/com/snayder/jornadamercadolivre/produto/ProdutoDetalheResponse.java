package com.snayder.jornadamercadolivre.produto;

import com.snayder.jornadamercadolivre.caracteristica.CaracteristicaResponse;
import com.snayder.jornadamercadolivre.categoria.CategoriaResponse;
import com.snayder.jornadamercadolivre.imagem.ImagemResponse;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record ProdutoDetalheResponse(
        Long id,
        String nome,
        BigDecimal valor,
        Integer quantidade,
        String descricao,
        CategoriaResponse categoria,
        Set<CaracteristicaResponse> caracteristicas,
        List<ImagemResponse> imagens,
        double media
) {
    public ProdutoDetalheResponse(Produto produto, double media) {
        this(
            produto.getId(),
            produto.getNome(),
            produto.getValor(),
            produto.getQuantidade(),
            produto.getDescricao(),
            new CategoriaResponse(produto.getCategoria()),
            produto.getCaracteristicas().stream().map(CaracteristicaResponse::new).collect(Collectors.toSet()),
            produto.getImagens().stream().map(ImagemResponse::new).toList(),
            media
        );
    }
}
