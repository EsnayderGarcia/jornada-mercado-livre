package com.snayder.jornadamercadolivre.imagem;

import com.snayder.jornadamercadolivre.produto.Produto;

public interface ImagemServico {
    Imagem processaImagem(ImagemRequest imagem, Produto produto);
}
