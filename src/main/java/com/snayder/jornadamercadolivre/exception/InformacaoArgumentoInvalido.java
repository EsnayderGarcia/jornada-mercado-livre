package com.snayder.jornadamercadolivre.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InformacaoArgumentoInvalido extends InformacaoErro {
    private final List<ArgumentoInvalidoDetalhe> erros = new ArrayList<>();

    public InformacaoArgumentoInvalido(int status, String erro, String path) {
        super(status, erro, path);
    }
}
