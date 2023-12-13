package com.snayder.jornadamercadolivre.usuario;

import com.snayder.jornadamercadolivre.validacoes.EmailUnico;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, message = "O nome deve conter no mínino {min} caractéres")
        String nome,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Informe um email válido")
        @EmailUnico(message = "Email já cadastrado")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 6, message = "A senha deve conter no mínino {min} caractéres")
        String senha
) {}
