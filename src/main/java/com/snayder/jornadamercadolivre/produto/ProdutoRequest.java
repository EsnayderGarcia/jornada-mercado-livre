package com.snayder.jornadamercadolivre.produto;

import com.snayder.jornadamercadolivre.caracteristica.CaracteristicaRequest;
import com.snayder.jornadamercadolivre.categoria.Categoria;
import com.snayder.jornadamercadolivre.validacoes.ExistId;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Set;

public record ProdutoRequest(
    @NotBlank(message = "Nome do produto é obrigatório")
    String nome,

    @NotNull(message = "Valor do produto é obrigatório")
    @Positive(message = "Valor deve ser positivo")
    BigDecimal valor,

    @NotNull(message = "Quantidade é obrigatória")
    @Positive(message = "Quantidade deve ser maior que zero")
    Integer quantidade,

    @Size(min = 3, message = "Informe pelo menos {min} caracteristicas")
    @NotEmpty(message = "Caracteristicas são obrigatórias")
    Set<CaracteristicaRequest> caracteristicas,

    @Length(max = 1000)
    @NotBlank(message = "Descrição é obrigatória")
    String descricao,

    @NotNull(message = "A categoria é obrigatória")
    @ExistId(message = "O id da categoria informada não existe", domainClass = Categoria.class)
    Long categoriaId
) {
    public Produto toModel() {
        Categoria categoria = Categoria.builder().id(categoriaId).build();
        return new Produto(nome, valor, quantidade, descricao, categoria, caracteristicas);
    }
}

