package com.snayder.jornadamercadolivre.opiniao;

import com.snayder.jornadamercadolivre.produto.Produto;
import com.snayder.jornadamercadolivre.usuario.Usuario;
import com.snayder.jornadamercadolivre.validacoes.ExistId;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OpiniaoRequest(
    @NotBlank(message = "Texto da avaliação é obrigatório")
    String texto,

    @NotNull(message = "A nota para o produto é obrigatório")
    @Min(value = 1, message = "A nota mínima é 1")
    @Max(value = 5, message = "A nota máxima é 5")
    Integer nota,

    @ExistId(message = "Produto não identificado", domainClass = Produto.class)
    Long idProduto,

    @ExistId(message = "Usuario não identificado", domainClass = Usuario.class)
    Long idUsuario
) {
    public Opiniao toEntidade(Usuario usuario, Produto produto) {
        return new Opiniao(texto, nota, usuario, produto);
    }
}
