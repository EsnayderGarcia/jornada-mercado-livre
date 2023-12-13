package com.snayder.jornadamercadolivre.validacoes;

import com.snayder.jornadamercadolivre.usuario.UsuarioRepositorio;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmailUnicoValidator implements ConstraintValidator<EmailUnico, String> {
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return usuarioRepositorio.findByEmail(email).isEmpty();
    }
}
