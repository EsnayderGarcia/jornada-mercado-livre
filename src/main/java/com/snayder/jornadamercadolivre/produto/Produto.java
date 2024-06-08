package com.snayder.jornadamercadolivre.produto;

import com.snayder.jornadamercadolivre.caracteristica.Caracteristica;
import com.snayder.jornadamercadolivre.caracteristica.CaracteristicaRequest;
import com.snayder.jornadamercadolivre.categoria.Categoria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tab_produtos")
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal valor;
    private Integer quantidade;
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private Set<Caracteristica> caracteristicas = new HashSet<>();
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Produto(String nome, BigDecimal valor, Integer quantidade, String descricao, Categoria categoria, Set<CaracteristicaRequest> caracteristicas) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = categoria;
        caracteristicas.forEach(c -> this.caracteristicas.add(new Caracteristica(c.nome(), this)));
    }
}
