package com.snayder.jornadamercadolivre.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tab_usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private LocalDateTime dataCriacao;

    public Usuario(UsuarioRequest usuarioRequest) {
        email = usuarioRequest.email();
        senha = usuarioRequest.senha();
    }

    @PrePersist
    public void createdAt() {
        dataCriacao = LocalDateTime.now();
    }
}
