package com.snayder.jornadamercadolivre.caracteristica;

import com.snayder.jornadamercadolivre.produto.Produto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tab_caracteristicas")
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Caracteristica(String descricao, Produto produto) {
        this.descricao = descricao;
        this.produto = produto;
    }
}
