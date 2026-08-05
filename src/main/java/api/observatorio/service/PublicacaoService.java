package api.observatorio.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import api.observatorio.dto.PublicacaoRequest;
import api.observatorio.dto.PublicacaoResponse;
import api.observatorio.mapper.PublicacaoMapper;
import api.observatorio.model.Categoria;
import api.observatorio.model.Publicacao;
import api.observatorio.repository.CategoriaRepository;
import api.observatorio.repository.PublicacaoRepository;

@Service
public class PublicacaoService {

    private final PublicacaoRepository repository;

    private final CategoriaRepository categoriaRepository;

    public PublicacaoService(

            PublicacaoRepository repository,

            CategoriaRepository categoriaRepository) {

        this.repository = repository;
        this.categoriaRepository = categoriaRepository;

    }

    public PublicacaoResponse buscarPorId(Long id) {
        // O findById já vem pronto do JpaRepository.
        // Usamos o orElseThrow para lançar um erro caso o ID não exista no banco.
        Publicacao publicacao = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publicação não encontrada"));

        return PublicacaoMapper.toResponse(publicacao);
    }

    public List<PublicacaoResponse> listar() {

        return repository.findAll()

                .stream()

                .map(PublicacaoMapper::toResponse)

                .toList();

    }

    public PublicacaoResponse salvar(PublicacaoRequest dto) {

        Categoria categoria = categoriaRepository.findById(dto.categoriaId())

                .orElseThrow();

        Publicacao publicacao = new Publicacao();

        publicacao.setTitulo(dto.titulo());

        publicacao.setAutor(dto.autor());

        publicacao.setResumo(dto.resumo());

        publicacao.setConteudo(dto.conteudo());

        publicacao.setCategoria(categoria);

        publicacao.setDataPublicacao(LocalDate.now());

        repository.save(publicacao);

        return PublicacaoMapper.toResponse(publicacao);

    }

    public void deletar(Long id) {

        repository.deleteById(id);

    }

}