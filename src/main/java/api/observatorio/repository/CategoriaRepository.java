package br.ifpi.observatorio.repository;

import br.ifpi.observatorio.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository
        extends JpaRepository<Categoria, Long> {

}
