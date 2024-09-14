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
import java.util.Objects;
import java.util.Optional;

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
    public ImagemResponse salvaImagem(Long idProduto, ImagemRequest imagemRequest) {
        Produto produto = consultarPorId(idProduto);

        if (imagemRequest.isPrincipal() && produto.temImagemPrincipal())
            produto.alteraValorImagemPrincipalAtual();

        Imagem imagem = imagemServico.processaImagem(imagemRequest, produto);
        produto.getImagens().add(imagem);
        produtoRepositorio.save(produto);

        return new ImagemResponse(imagem);
    }

    @Transactional
    public ImagemResponse atualizaImagemPrincipal(Long idProduto, Long idImagem) {
        Produto produto = consultarPorId(idProduto);
        Optional<Imagem> possivelImagemPrincipal = produto.getImagemPrincipal();

        if (possivelImagemPrincipal.isPresent() && Objects.equals(possivelImagemPrincipal.get().getId(), idImagem))
            throw new IllegalArgumentException("Irmão, você tá querendo atualizar uma imagem que já é a principal, fica ligado");

        produto.alteraValorImagemPrincipalAtual();
        return new ImagemResponse(produto.atualizaImagemPrincipal(idImagem));
    }
}
