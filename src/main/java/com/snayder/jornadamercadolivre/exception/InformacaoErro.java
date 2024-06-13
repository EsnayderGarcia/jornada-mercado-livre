package com.snayder.jornadamercadolivre.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InformacaoErro {
    private int status;
    private String mensagem;
    private String path;
}
