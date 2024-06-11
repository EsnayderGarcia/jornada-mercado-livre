package com.snayder.jornadamercadolivre.produto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoRecurso {
    private final ProdutoRepositorio produtoRepositorio;

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoResponse> salva(@RequestBody @Valid ProdutoRequest produtoRequest) {
        Produto produto = produtoRepositorio.save(produtoRequest.toModel());
        return ResponseEntity.ok(new ProdutoResponse(produto));
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<ProdutoResponse>> busca() {
        List<ProdutoResponse> produtos = produtoRepositorio.findAll().stream().map(ProdutoResponse::new).toList();
        return ResponseEntity.ok(produtos);
    }
}
