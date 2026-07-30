package api.observatorio.mapper;

import api.observatorio.dto.PublicacaoResponse;
import api.observatorio.model.Publicacao;

public class PublicacaoMapper {

    public static PublicacaoResponse toResponse(Publicacao publicacao){

        return new PublicacaoResponse(

                publicacao.getId(),

                publicacao.getTitulo(),

                publicacao.getAutor(),

                publicacao.getResumo(),

                publicacao.getConteudo(),

                publicacao.getCategoria().getNome(),

                publicacao.getImagemCapa(),

                publicacao.getArquivoPdf(),

                publicacao.getDataPublicacao()

        );

    }

}