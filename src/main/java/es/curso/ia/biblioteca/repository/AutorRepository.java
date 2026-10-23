package es.curso.ia.biblioteca.repository;
import es.curso.ia.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AutorRepository extends JpaRepository<Autor, Long> { }
