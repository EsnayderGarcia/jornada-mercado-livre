package com.snayder.jornadamercadolivre.imagem;

import org.springframework.web.multipart.MultipartFile;

public interface ImagemServico {
    String processaImagem(MultipartFile imagem);
}
