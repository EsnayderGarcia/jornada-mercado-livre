package com.snayder.jornadamercadolivre.usuario;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioRecurso {
    private final UsuarioRepositorio usuarioRepositorio;

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioResponse> salva(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRepositorio.save(usuarioRequest.toModel());
        return new ResponseEntity<>(new UsuarioResponse(usuario), HttpStatus.OK);
    }
}
