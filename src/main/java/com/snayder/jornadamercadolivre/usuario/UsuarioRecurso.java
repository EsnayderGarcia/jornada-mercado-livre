package com.snayder.jornadamercadolivre.usuario;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    private final UsuarioServico usuarioServico;

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioResponse> salvar(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        return ResponseEntity.ok(new UsuarioResponse(usuarioServico.salvar(usuarioRequest)));
    }
}
