package api.observatorio.service;

import java.util.List;
import org.springframework.stereotype.Service;

import api.observatorio.dto.CategoriaRequest;
import api.observatorio.dto.CategoriaResponse;
import api.observatorio.mapper.CategoriaMapper;
import api.observatorio.model.Categoria;
import api.observatorio.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository){

        this.repository = repository;

    }

    public List<CategoriaResponse> listar(){

        return repository.findAll()

                .stream()

                .map(CategoriaMapper::toResponse)

                .toList();

    }

    public CategoriaResponse salvar(CategoriaRequest dto){

        Categoria categoria = CategoriaMapper.toEntity(dto);

        categoria = repository.save(categoria);

        return CategoriaMapper.toResponse(categoria);

    }

}