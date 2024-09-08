package com.snayder.jornadamercadolivre.imagem;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Profile("dev")
public class ImagemFakeServico implements ImagemServico{
    @Override
    public String processaImagem(MultipartFile imagem) {
        return imagem.getOriginalFilename();
    }
}
