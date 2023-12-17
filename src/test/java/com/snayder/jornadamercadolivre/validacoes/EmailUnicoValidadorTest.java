package com.snayder.jornadamercadolivre.validacoes;

import com.snayder.jornadamercadolivre.usuario.Usuario;
import com.snayder.jornadamercadolivre.usuario.UsuarioRepositorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmailUnicoValidadorTest {
    UsuarioRepositorio usuarioRepositorio = mock(UsuarioRepositorio.class);
    EmailUnicoValidator emailUnicoValidator = new EmailUnicoValidator(usuarioRepositorio);
    final String emailExistente = "emailexistente@gmail.com";
    final String emailNaoExistente = "emailnaoexistente@gmail.com";

    @Test
    @DisplayName("Deve retornar falso, indicando que o email informado já existe")
    void emailExistenteTest() {
        when(usuarioRepositorio.findByEmail(emailExistente)).thenReturn(Optional.of(new Usuario()));
        assertFalse(emailUnicoValidator.isValid(emailExistente, null));
    }

    @Test
    @DisplayName("Deve retornar verdadeiro, indicando que o email informado ainda não existe")
    void emailNaoExistenteTest() {
        when(usuarioRepositorio.findByEmail(emailNaoExistente)).thenReturn(Optional.empty());
        assertTrue(emailUnicoValidator.isValid(emailNaoExistente, null));
    }
}
