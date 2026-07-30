package api.observatorio.mapper;

import api.observatorio.dto.*;
import api.observatorio.model.Categoria;

public class CategoriaMapper {

    public static Categoria toEntity(CategoriaRequest dto){

        Categoria categoria = new Categoria();

        categoria.setNome(dto.nome());
        categoria.setDescricao(dto.descricao());

        return categoria;
    }

    public static CategoriaResponse toResponse(Categoria categoria){

        return new CategoriaResponse(

                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()

        );
    }

}
