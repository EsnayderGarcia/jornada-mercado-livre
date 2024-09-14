package com.snayder.jornadamercadolivre.caracteristica;

public record CaracteristicaResponse(Long id, String nome, String descricao) {
    public CaracteristicaResponse(Caracteristica caracteristica) {
        this(caracteristica.getId(), caracteristica.getNome(), caracteristica.getDescricao());
    }
}
