package br.ifpi.observatorio.dto;

import java.time.LocalDate;

public record PublicacaoResponse(

    Long id,

    String titulo,

    String autor,

    String resumo,

    String conteudo,

    String categoria,

    String imagemCapa,

    String arquivoPdf,

    LocalDate dataPublicacao

) {
}