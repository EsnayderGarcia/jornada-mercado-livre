package com.snayder.jornadamercadolivre.categoria;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categorias")
@RequiredArgsConstructor
public class CategoriaRecurso {
    private final CategoriaRepositorio categoriaRepositorio;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaResponse> salva(@RequestBody CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRepositorio.save(categoriaRequest.toModel(categoriaRepositorio));
        return ResponseEntity.ok(new CategoriaResponse(categoria));
    }
}
