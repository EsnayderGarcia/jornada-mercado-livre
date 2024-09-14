package com.snayder.jornadamercadolivre.produto;

import com.snayder.jornadamercadolivre.imagem.ImagemServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoRecurso {
    private final ProdutoServico produtoServico;
    private final ImagemServico imagemServico;

    @PostMapping
    public ResponseEntity<ProdutoSalvoResponse> salva(@RequestBody @Valid ProdutoRequest produtoRequest) {
        return ResponseEntity.ok(new ProdutoSalvoResponse(produtoServico.salvar(produtoRequest)));
    }

    @GetMapping()
    public ResponseEntity<List<ProdutoResumoResponse>> buscaResumosProdutos() {
        List<ProdutoResumoResponse> produtos = produtoServico.consultar()
                .stream()
                .map(ProdutoResumoResponse::new)
                .toList();

        return ResponseEntity.ok(produtos);
    }
}
