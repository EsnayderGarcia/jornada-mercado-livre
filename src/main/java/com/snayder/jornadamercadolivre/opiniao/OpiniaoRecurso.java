package com.snayder.jornadamercadolivre.opiniao;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("opinioes")
@RequiredArgsConstructor
public class OpiniaoRecurso {
    private final OpiniaoRepositorio opiniaoRepositorio;
    private final OpiniaoServico opiniaoServico;

    @GetMapping("{idProduto}/produto")
    public ResponseEntity<List<OpiniaoResponse>> getOpnioesByProduto(@PathVariable Long idProduto) {
        List<OpiniaoResponse> opinioes = opiniaoServico.consultarPorProduto(idProduto)
                .stream()
                .map(OpiniaoResponse::new)
                .toList();

        return ResponseEntity.ok(opinioes);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<OpiniaoResponse> salvar(@RequestBody @Valid OpiniaoRequest opiniaoRequest) {
        return ResponseEntity.ok(new OpiniaoResponse(opiniaoServico.salvar(opiniaoRequest)));
    }
}
