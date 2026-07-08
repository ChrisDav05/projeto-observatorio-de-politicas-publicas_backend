package br.ifpi.observatorio.service;

import br.ifpi.observatorio.model.Publicacao;
import br.ifpi.observatorio.repository.PublicacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacaoService {

    private final PublicacaoRepository repository;

    public PublicacaoService(PublicacaoRepository repository) {
        this.repository = repository;
    }

    public List<Publicacao> listar() {
        return repository.findAll();
    }

    public Publicacao salvar(Publicacao publicacao) {
        return repository.save(publicacao);
    }

    public List<Publicacao> buscarPorTitulo(String titulo) {
        return repository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Publicacao> buscarPorCategoria(Long id) {
        return repository.findByCategoriaId(id);
    }

}