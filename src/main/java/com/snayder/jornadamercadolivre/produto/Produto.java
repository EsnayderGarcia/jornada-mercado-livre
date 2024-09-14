package com.snayder.jornadamercadolivre.produto;

import com.snayder.jornadamercadolivre.caracteristica.Caracteristica;
import com.snayder.jornadamercadolivre.caracteristica.CaracteristicaRequest;
import com.snayder.jornadamercadolivre.categoria.Categoria;
import com.snayder.jornadamercadolivre.imagem.Imagem;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "tab_produtos")
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private BigDecimal valor;
    private Integer quantidade;
    private String descricao;
    private String urlImagem;
    @ManyToOne
    private Categoria categoria;
    @OneToMany(mappedBy = "produto", cascade = CascadeType.PERSIST)
    private Set<Caracteristica> caracteristicas = new HashSet<>();
    @OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
    private List<Imagem> imagens = new ArrayList<>();

    public Produto(String nome,
                   BigDecimal valor,
                   Integer quantidade,
                   String descricao,
                   Categoria categoria,
                   Set<CaracteristicaRequest> caracteristicas) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = categoria;
        this.caracteristicas.addAll(caracteristicas.stream().map(c -> c.toModel(this)).collect(Collectors.toSet()));
    }

    public Optional<Imagem> getImagemPrincipal() {
        return imagens.stream()
            .filter(Imagem::getIsPrincipal)
            .findFirst();
    }

    public void alteraValorImagemPrincipalAtual() {
        getImagemPrincipal().ifPresent(imagem -> imagem.setIsPrincipal(false));
    }

    public Imagem atualizaImagemPrincipal(Long idImagem) {
        return imagens.stream()
            .filter(imagem -> Objects.equals(imagem.getId(), idImagem))
            .peek(imagem -> imagem.setIsPrincipal(true))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Imagem não identificada"));
    }

    public boolean temImagemPrincipal() {
        return getImagemPrincipal().isPresent();
    }
}
