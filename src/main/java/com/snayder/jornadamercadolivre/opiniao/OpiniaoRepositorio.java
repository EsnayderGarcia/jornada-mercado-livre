package com.snayder.jornadamercadolivre.opiniao;

import com.snayder.jornadamercadolivre.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OpiniaoRepositorio extends JpaRepository<Opiniao, Long> {
    List<Opiniao> findAllByProdutoIdOrderByDataDesc(Long idProduto);

    @Query("SELECT AVG(op.nota) FROM Opiniao op WHERE op.produto = :produto")
    Optional<Double> obterMediaNotasProduto(Produto produto);
}
