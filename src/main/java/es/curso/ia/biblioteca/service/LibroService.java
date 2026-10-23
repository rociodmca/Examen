package es.curso.ia.biblioteca.service;
import es.curso.ia.biblioteca.model.Libro;
import es.curso.ia.biblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service public class LibroService {
    private final LibroRepository repo;
    public LibroService(LibroRepository repo) { this.repo=repo; }
    public List<Libro> findAll() { return repo.findAll(); }
    public Libro findById(Long id) { return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Libro no encontrado")); }
    public Libro save(Libro libro) { return repo.save(libro); }
    public void delete(Long id) { repo.deleteById(id); }
    public boolean isbnDuplicado(String isbn, Long id) { return id == null ? repo.findAll().stream().anyMatch(l -> l.getIsbn().equalsIgnoreCase(isbn)) : repo.existsByIsbnAndIdNot(isbn, id); }
}
