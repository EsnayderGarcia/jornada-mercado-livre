package com.snayder.jornadamercadolivre.caracteristica;

public record CaracteristicaResponse(Long id, String descricao) {
    public CaracteristicaResponse(Caracteristica caracteristica) {
        this(caracteristica.getId(), caracteristica.getDescricao());
    }
}
