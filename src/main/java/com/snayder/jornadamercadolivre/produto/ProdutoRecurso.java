package com.snayder.jornadamercadolivre.produto;

import com.snayder.jornadamercadolivre.imagem.ImagemRequest;
import com.snayder.jornadamercadolivre.imagem.ImagemResponse;
import com.snayder.jornadamercadolivre.opiniao.OpiniaoServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoRecurso {
    private final ProdutoServico produtoServico;
    private final OpiniaoServico opiniaoServico;

    @PostMapping
    public ResponseEntity<ProdutoSalvoResponse> salva(@RequestBody @Valid ProdutoRequest produtoRequest) {
        return ResponseEntity.ok(new ProdutoSalvoResponse(produtoServico.salvar(produtoRequest)));
    }

    @GetMapping()
    public ResponseEntity<List<ProdutoResumoResponse>> consultaProdutos() {
        List<ProdutoResumoResponse> produtos = produtoServico.consultar()
                .stream()
                .map(ProdutoResumoResponse::new)
                .toList();

        return ResponseEntity.ok(produtos);
    }

    @GetMapping("{idProduto}")
    public ResponseEntity<ProdutoDetalheResponse> consultaProduto(@PathVariable Long idProduto) {
        return ResponseEntity.ok(new ProdutoDetalheResponse(
            produtoServico.consultarPorId(idProduto),
            opiniaoServico.obterMediaNotasProduto(idProduto)
        ));
    }

    @PutMapping(value = "{idProduto}/imagens", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ImagemResponse> salvaImagens(@PathVariable Long idProduto, @Valid ImagemRequest imagem) {
        return ResponseEntity.ok(produtoServico.salvaImagem(idProduto, imagem));
    }

    @PutMapping(value = "{idProduto}/imagens/{idImagem}")
    public ResponseEntity<ImagemResponse> ataulizaImagenPrincipal(@PathVariable Long idProduto, @PathVariable Long idImagem) {
        return ResponseEntity.ok(produtoServico.atualizaImagemPrincipal(idProduto, idImagem));
    }
}
