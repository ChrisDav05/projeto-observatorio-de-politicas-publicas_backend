package br.ifpi.observatorio.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequest(

    @NotBlank(message = "O nome da categoria é obrigatório.")
    String nome,

    String descricao

) {
}