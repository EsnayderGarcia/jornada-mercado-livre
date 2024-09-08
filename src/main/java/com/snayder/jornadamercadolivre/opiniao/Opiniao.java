package com.snayder.jornadamercadolivre.opiniao;

import com.snayder.jornadamercadolivre.produto.Produto;
import com.snayder.jornadamercadolivre.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tab_avaliacoes")
@NoArgsConstructor
public class Opiniao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String texto;

    private Integer nota;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Produto produto;

    private LocalDateTime data;

    public Opiniao(String texto, Integer nota, Usuario usuario, Produto produto) {
        this.texto = texto;
        this.nota = nota;
        this.usuario = usuario;
        this.produto = produto;
        data = LocalDateTime.now();
    }
}
