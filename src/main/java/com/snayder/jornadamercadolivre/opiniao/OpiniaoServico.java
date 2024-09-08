package com.snayder.jornadamercadolivre.opiniao;

import com.snayder.jornadamercadolivre.produto.Produto;
import com.snayder.jornadamercadolivre.produto.ProdutoServico;
import com.snayder.jornadamercadolivre.usuario.Usuario;
import com.snayder.jornadamercadolivre.usuario.UsuarioServico;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OpiniaoServico {
    private final OpiniaoRepositorio opiniaoRepositorio;
    private final UsuarioServico usuarioServico;
    private final ProdutoServico produtoServico;

    public List<Opiniao> consultarPorProduto(Long idProduto) {
        return opiniaoRepositorio.findAllByProdutoIdOrderByDataDesc(idProduto);
    }

    @Transactional
    public Opiniao salvar(OpiniaoRequest opiniaoRequest) {
        Usuario usuario = usuarioServico.consultarPorId(opiniaoRequest.idUsuario());
        Produto produto = produtoServico.consultarPorId(opiniaoRequest.idProduto());

        return opiniaoRepositorio.save(opiniaoRequest.toEntidade(usuario, produto));
    }

    @Transactional(readOnly = true)
    public Double obterMediaNotasProduto(Long idProduto) {
        Produto produto = produtoServico.consultarPorId(idProduto);
        return opiniaoRepositorio.obterMediaNotasProduto(produto).orElse(0.0);
    }
}
