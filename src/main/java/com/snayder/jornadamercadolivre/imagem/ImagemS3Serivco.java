package com.snayder.jornadamercadolivre.imagem;

import com.snayder.jornadamercadolivre.produto.Produto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ImagemS3Serivco implements ImagemServico {
    @Override
    public Imagem processaImagem(ImagemRequest imagem, Produto produto) {
      return null;
    }
}
