package com.snayder.jornadamercadolivre.produto;

import com.snayder.jornadamercadolivre.imagem.ImagemServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoRecurso {
    private final ProdutoServico produtoServico;
    private final ImagemServico imagemServico;

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoResponse> salva(@RequestBody @Valid ProdutoRequest produtoRequest) {
        return ResponseEntity.ok(new ProdutoResponse(produtoServico.salvar(produtoRequest)));
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<ProdutoResponse>> busca() {
        List<ProdutoResponse> produtos = produtoServico.consultar()
                .stream()
                .map(ProdutoResponse::new)
                .toList();

        return ResponseEntity.ok(produtos);
    }

    @PostMapping("{idProduto}/cadastrar-imagem")
    @Transactional
    public ResponseEntity<String> cadastraImagem(@PathVariable Long idProduto, MultipartFile imagem) {
        produtoServico.salvarImagem(idProduto, imagem);
        return ResponseEntity.noContent().build();
    }
}
