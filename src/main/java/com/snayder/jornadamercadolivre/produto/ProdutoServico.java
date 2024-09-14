package com.snayder.jornadamercadolivre.produto;

import com.snayder.jornadamercadolivre.exception.RecursoNaoEncontradoException;
import com.snayder.jornadamercadolivre.imagem.ImagemServico;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServico {
    private final ProdutoRepositorio produtoRepositorio;
    private final ImagemServico imagemServico;

    @Transactional
    public Produto salvar(ProdutoRequest produtoRequest) {
        return produtoRepositorio.save(produtoRequest.toModel());
    }

    @Transactional(readOnly = true)
    public List<Produto> consultar() {
        return produtoRepositorio.findAll();
    }

    public Produto consultarPorId(Long id) {
        return produtoRepositorio.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não identificado"));
    }
}
