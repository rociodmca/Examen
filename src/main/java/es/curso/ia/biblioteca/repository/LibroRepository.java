package es.curso.ia.biblioteca.repository;
import es.curso.ia.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LibroRepository extends JpaRepository<Libro, Long> { boolean existsByIsbnAndIdNot(String isbn, Long id); }
