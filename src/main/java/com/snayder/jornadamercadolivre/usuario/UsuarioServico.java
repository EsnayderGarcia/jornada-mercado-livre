package com.snayder.jornadamercadolivre.usuario;

import com.snayder.jornadamercadolivre.exception.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioServico {
    private final UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public Usuario salvar(UsuarioRequest usuarioRequest) {
        return usuarioRepositorio.save(usuarioRequest.toEntidade());
    }

    public Usuario consultarPorId(Long id) {
        return usuarioRepositorio.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não identificado"));
    }
}
