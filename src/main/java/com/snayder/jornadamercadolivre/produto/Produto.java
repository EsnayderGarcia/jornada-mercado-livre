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
import java.util.stream.Collectors;

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
    private String descricao;
    private String urlImagem;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @OneToMany(mappedBy = "produto", cascade = CascadeType.PERSIST)
    private Set<Caracteristica> caracteristicas = new HashSet<>();

    public Produto(
            String nome,
            BigDecimal valor,
            Integer quantidade,
            String descricao,
            Categoria categoria,
            Set<CaracteristicaRequest> caracteristicas
    ) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = categoria;
        this.caracteristicas.addAll(caracteristicas.stream().map(c -> c.toModel(this)).collect(Collectors.toSet()));
    }
}
