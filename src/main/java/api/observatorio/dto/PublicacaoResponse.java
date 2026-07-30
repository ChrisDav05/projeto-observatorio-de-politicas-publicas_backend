package br.ifpi.observatorio.dto.publicacao;

import java.time.LocalDate;

public record PublicacaoResponse(

        Long id,

        String titulo,

        String autor,

        String resumo,

        String conteudo,

        String categoria,

        String imagem,

        String pdf,

        LocalDate dataPublicacao

) {
}