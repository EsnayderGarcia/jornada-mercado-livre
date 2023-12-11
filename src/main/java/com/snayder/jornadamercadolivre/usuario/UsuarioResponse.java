package com.snayder.jornadamercadolivre.usuario;

public record UsuarioResponse(Long id, String email) {
    public UsuarioResponse(Usuario usuario) {
        this(usuario.getId(), usuario.getEmail());
    }
}
