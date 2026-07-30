package api.observatorio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PublicacaoRequest(

        @NotBlank
        String titulo,

        @NotBlank
        String autor,

        String resumo,

        String conteudo,

        @NotNull
        Long categoriaId

) {
}       