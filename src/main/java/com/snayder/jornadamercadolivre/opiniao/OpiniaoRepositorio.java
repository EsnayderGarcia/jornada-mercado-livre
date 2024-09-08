package com.snayder.jornadamercadolivre.opiniao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpiniaoRepositorio extends JpaRepository<Opiniao, Long> {
    List<Opiniao> findAllByProdutoIdOrderByDataDesc(Long idProduto);
}
