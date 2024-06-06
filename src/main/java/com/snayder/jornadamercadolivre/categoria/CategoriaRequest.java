package com.snayder.jornadamercadolivre.categoria;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public record CategoriaRequest(
    @NotBlank(message = "Nome da categoria é obrigatório")
    String nome,
    Long categoriaMaeId
) {
    public Categoria toModel(CategoriaRepositorio categoriaRepositorio) {
        Categoria categoria = new Categoria(nome);

        if (Objects.nonNull(categoriaMaeId)) {
            Categoria categoriaMae = categoriaRepositorio.findById(categoriaMaeId)
                .orElseThrow(() -> new IllegalArgumentException("Categoria mãe informada não existe"));

            categoria.setCategoriaMae(categoriaMae);
        }

        return categoria;
    }
}
