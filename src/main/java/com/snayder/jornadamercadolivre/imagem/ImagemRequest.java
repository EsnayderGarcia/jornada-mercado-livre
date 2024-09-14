package com.snayder.jornadamercadolivre.imagem;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record ImagemRequest(
    @NotNull(message = "Informe se esta sera a imagem principal do produto")
    Boolean isPrincipal,
    MultipartFile file
) {}
