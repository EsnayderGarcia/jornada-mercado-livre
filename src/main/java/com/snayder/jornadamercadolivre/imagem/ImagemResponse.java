package com.snayder.jornadamercadolivre.imagem;

public record ImagemResponse(Long id, String url, Long tamanho, Boolean isPrincipal) {
    public ImagemResponse(Imagem imagem) {
        this(imagem.getId(), imagem.getUrl(), imagem.getTamanho(), imagem.getIsPrincipal());
    }
}
