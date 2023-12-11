package com.snayder.jornadamercadolivre.usuario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UsuarioServico {
    private final UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public UsuarioResponse cadastrar(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario(usuarioRequest);
        return new UsuarioResponse(usuarioRepositorio.save(usuario));
    }
}
