package es.curso.ia.biblioteca.controller;
import es.curso.ia.biblioteca.model.Libro; import es.curso.ia.biblioteca.service.*;
import jakarta.validation.Valid; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.validation.BindingResult; import org.springframework.web.bind.annotation.*;
@Controller @RequestMapping("/libros") public class LibroController {
    private final LibroService libros; private final AutorService autores;
    public LibroController(LibroService libros, AutorService autores) { this.libros=libros; this.autores=autores; }
    @GetMapping public String list(Model m) { m.addAttribute("libros", libros.findAll()); return "libros/lista"; }
    @GetMapping("/nuevo") public String nuevo(Model m) { m.addAttribute("libro", new Libro()); m.addAttribute("autores", autores.findAll()); return "libros/formulario"; }
    @PostMapping("/guardar") public String guardar(@Valid @ModelAttribute Libro libro, BindingResult result, @RequestParam Long autorId, Model m) {
        libro.setAutor(autores.findById(autorId)); if(libros.isbnDuplicado(libro.getIsbn(), libro.getId())) result.rejectValue("isbn", "duplicado", "Ya existe un libro con ese ISBN");
        if(result.hasErrors()) { m.addAttribute("autores", autores.findAll()); return "libros/formulario"; } libros.save(libro); return "redirect:/libros";
    }
    @GetMapping("/editar/{id}") public String editar(@PathVariable Long id, Model m) { Libro l=libros.findById(id); m.addAttribute("libro", l); m.addAttribute("autores", autores.findAll()); return "libros/formulario"; }
    @PostMapping("/borrar/{id}") public String borrar(@PathVariable Long id) { libros.delete(id); return "redirect:/libros"; }
}
