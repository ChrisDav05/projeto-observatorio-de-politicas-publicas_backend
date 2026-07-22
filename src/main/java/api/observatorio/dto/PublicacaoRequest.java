package br.ifpi.observatorio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PublicacaoRequest(

    @NotBlank(message = "O título é obrigatório.")
    String titulo,

    @NotBlank(message = "O autor é obrigatório.")
    String autor,

    String resumo,

    String conteudo,

    @NotNull(message = "A categoria é obrigatória.")
    Long categoriaId

) {
}   