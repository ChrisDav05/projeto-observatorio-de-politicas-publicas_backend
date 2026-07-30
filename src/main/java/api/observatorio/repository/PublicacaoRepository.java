package api.observatorio.repository;

import api.observatorio.model.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicacaoRepository
        extends JpaRepository<Publicacao, Long> {

    List<Publicacao> findByTituloContainingIgnoreCase(String titulo);

    List<Publicacao> findByCategoriaId(Long categoriaId);

}
