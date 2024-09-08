package com.snayder.jornadamercadolivre.opiniao;

import java.time.LocalDateTime;

public record OpiniaoResponse(
    Long id,
    String texto,
    Integer nota,
    String nomeUsuario,
    LocalDateTime data
) {
    public OpiniaoResponse(Opiniao opiniao) {
        this(
            opiniao.getId(),
            opiniao.getTexto(),
            opiniao.getNota(),
            opiniao.getUsuario().getNome(),
            opiniao.getData()
        );
    }
}
