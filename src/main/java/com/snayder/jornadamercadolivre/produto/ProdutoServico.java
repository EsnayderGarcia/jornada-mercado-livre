package com.snayder.jornadamercadolivre.produto;

import com.snayder.jornadamercadolivre.exception.RecursoNaoEncontradoException;
import com.snayder.jornadamercadolivre.imagem.ImagemServico;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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

    public List<Produto> consultar() {
        return produtoRepositorio.findAll();
    }

    public Produto consultarPorId(Long id) {
        return produtoRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não identificado"));
    }

    @Transactional
    public void salvarImagem(Long id, MultipartFile imagem) {
        Produto produto = consultarPorId(id);
        produto.setUrlImagem(imagem.getOriginalFilename());
        produtoRepositorio.save(produto);
    }
}
