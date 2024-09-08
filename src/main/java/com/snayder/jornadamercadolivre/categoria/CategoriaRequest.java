package com.snayder.jornadamercadolivre.categoria;

import com.snayder.jornadamercadolivre.validacoes.ExistId;
import com.snayder.jornadamercadolivre.validacoes.UniqueValue;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public record CategoriaRequest(
    @NotBlank(message = "Nome da categoria é obrigatório")
    @UniqueValue(message = "O nome da categoria deve ser único", domainClass = Categoria.class, fieldName = "nome")
    String nome,
    @ExistId(message = "O id da categoria mãe informado não existe", domainClass = Categoria.class)
    Long categoriaMaeId
) {
    public Categoria toModel(CategoriaRepositorio categoriaRepositorio) {
        Categoria categoria = new Categoria(nome);

        if (Objects.nonNull(categoriaMaeId)) {
            Categoria categoriaMae =  categoriaRepositorio.getReferenceById(categoriaMaeId);
            categoria.setCategoriaMae(categoriaMae);
        }

        return categoria;
    }
}
