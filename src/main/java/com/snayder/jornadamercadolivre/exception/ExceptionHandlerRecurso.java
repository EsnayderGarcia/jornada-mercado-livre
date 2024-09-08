package com.snayder.jornadamercadolivre.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerRecurso {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<InformacaoErro> recursoNaoEncontrado(RecursoNaoEncontradoException ex, HttpServletRequest req) {
        InformacaoErro informacaoErro = new InformacaoErro(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                req.getRequestURI()
        );

        return new ResponseEntity<>(informacaoErro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<InformacaoArgumentoInvalido> argumentoInvalido(MethodArgumentNotValidException ex,
                                                                         HttpServletRequest req) {
        InformacaoArgumentoInvalido informacaoArgumentoInvalido = new InformacaoArgumentoInvalido(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            "Um ou mais campos estão inválidos",
            req.getRequestURI()
        );

        ex.getBindingResult().getFieldErrors().forEach(e ->
            informacaoArgumentoInvalido.getErros().add(new ArgumentoInvalidoDetalhe(e.getField(), e.getDefaultMessage()))
        );

        return new ResponseEntity<>(informacaoArgumentoInvalido, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
