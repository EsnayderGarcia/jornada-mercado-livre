package com.snayder.jornadamercadolivre.imagem;

import com.snayder.jornadamercadolivre.produto.Produto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tab_imagens")
public class Imagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private Long tamanho;
    private Boolean isPrincipal;
    @ManyToOne
    private Produto produto;

    public Imagem(String url, Long tamanho, Boolean isPrincipal, Produto produto) {
        this.url = url;
        this.tamanho = tamanho;
        this.isPrincipal = isPrincipal;
        this.produto = produto;
    }
}
