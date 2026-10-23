package es.curso.ia.biblioteca.service;
import es.curso.ia.biblioteca.model.Autor;
import es.curso.ia.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service public class AutorService {
    private final AutorRepository repo;
    public AutorService(AutorRepository repo) { this.repo=repo; }
    public List<Autor> findAll() { return repo.findAll(); }
    public Autor findById(Long id) { return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Autor no encontrado")); }
    public Autor save(Autor autor) { return repo.save(autor); }
    public void delete(Long id) { repo.deleteById(id); }
}
