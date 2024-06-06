package com.snayder.jornadamercadolivre.categoria;

import java.util.Objects;

public record CategoriaResponse(Long id, String nome, CategoriaResponse categoriaMae) {
    public CategoriaResponse(Categoria categoria) {
        this(
            categoria.getId(),
            categoria.getNome(),
            Objects.isNull(categoria.getCategoriaMae()) ? null : new CategoriaResponse(categoria.getCategoriaMae())
        );
    }
}
