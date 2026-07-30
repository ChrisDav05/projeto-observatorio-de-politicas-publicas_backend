package br.ifpi.observatorio.dto.categoria;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequest(

        @NotBlank
        String nome,

        String descricao

) {
}