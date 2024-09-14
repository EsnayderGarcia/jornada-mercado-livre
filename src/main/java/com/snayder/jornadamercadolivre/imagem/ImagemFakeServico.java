package com.snayder.jornadamercadolivre.imagem;

import com.snayder.jornadamercadolivre.produto.Produto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Profile("dev")
public class ImagemFakeServico implements ImagemServico {
    @Override
    public Imagem processaImagem(ImagemRequest imagemRequest, Produto produto) {
        return new Imagem(
            String.format("https://imagem-repo-fake/%s-%s.com", UUID.randomUUID().toString(), imagemRequest.file().getOriginalFilename()),
            imagemRequest.file().getSize(),
            !imagemRequest.isPrincipal() && !produto.temImagemPrincipal() ? true : imagemRequest.isPrincipal(),
            produto
        );
    }
}
