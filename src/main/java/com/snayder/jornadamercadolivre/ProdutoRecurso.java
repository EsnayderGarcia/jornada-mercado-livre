package com.snayder.jornadamercadolivre;

import com.snayder.jornadamercadolivre.produto.Produto;
import com.snayder.jornadamercadolivre.produto.ProdutoRepositorio;
import com.snayder.jornadamercadolivre.produto.ProdutoRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoRecurso {
    private final ProdutoRepositorio produtoRepositorio;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> salva(@RequestBody @Valid ProdutoRequest produtoRequest) {
        Produto produto = produtoRepositorio.save(produtoRequest.toModel());
        return ResponseEntity.ok("produto");
    }
}
