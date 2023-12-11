package com.snayder.jornadamercadolivre.usuario;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
@AllArgsConstructor
public class UsuarioRecurso {
    private final UsuarioServico usuarioServico;

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrar(@RequestBody UsuarioRequest usuarioRequest) {
        return new ResponseEntity<>(usuarioServico.cadastrar(usuarioRequest), HttpStatus.OK);
    }
}
