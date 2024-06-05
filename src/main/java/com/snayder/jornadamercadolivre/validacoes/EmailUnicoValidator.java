package com.snayder.jornadamercadolivre.validacoes;

import com.snayder.jornadamercadolivre.usuario.UsuarioRepositorio;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, String> {
    private final UsuarioRepositorio usuarioRepositorio;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return usuarioRepositorio.findByEmail(email).isEmpty();
    }
}
