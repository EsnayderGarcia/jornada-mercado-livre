package com.snayder.jornadamercadolivre.produto;

import com.snayder.jornadamercadolivre.exception.RecursoNaoEncontradoException;
import com.snayder.jornadamercadolivre.imagem.Imagem;
import com.snayder.jornadamercadolivre.imagem.ImagemRequest;
import com.snayder.jornadamercadolivre.imagem.ImagemResponse;
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

    @Transactional
    public ImagemResponse salvaImagem(Long idProduto, ImagemRequest imagemRequest) {
        Produto produto = consultarPorId(idProduto);
        List<Imagem> imagensSalvas = produto.getImagens();

        if (imagemRequest.isPrincipal() && !imagensSalvas.isEmpty())
            produto.alteraValorImagemPrincipalAtual();

        Imagem imagem = imagemServico.processaImagem(imagemRequest, produto);
        imagensSalvas.add(imagem);
        produtoRepositorio.save(produto);

        return new ImagemResponse(imagem);
    }

    @Transactional
    public ImagemResponse atualizaImagemPrincipal(Long idProduto, Long idImagem) {
        Produto produto = consultarPorId(idProduto);
        produto.alteraValorImagemPrincipalAtual();

        return new ImagemResponse(produto.atualizaImagemPrincipal(idImagem));
    }
}
