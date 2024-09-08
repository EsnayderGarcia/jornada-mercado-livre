package com.snayder.jornadamercadolivre.categoria;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categorias")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne()
    private Categoria categoriaMae;

    public Categoria(String nome) {
        this.nome = nome;
    }
}
