package es.curso.ia.biblioteca.controller;
import es.curso.ia.biblioteca.model.Autor; import es.curso.ia.biblioteca.service.AutorService;
import jakarta.validation.Valid; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.validation.BindingResult; import org.springframework.web.bind.annotation.*;
@Controller @RequestMapping("/autores") public class AutorController {
    private final AutorService service; public AutorController(AutorService service) { this.service=service; }
    @GetMapping public String list(Model m) { m.addAttribute("autores", service.findAll()); return "autores/lista"; }
    @GetMapping("/nuevo") public String nuevo(Model m) { m.addAttribute("autor", new Autor()); return "autores/formulario"; }
    @PostMapping("/guardar") public String guardar(@Valid @ModelAttribute Autor autor, BindingResult result) { if(result.hasErrors()) return "autores/formulario"; service.save(autor); return "redirect:/autores"; }
    @GetMapping("/editar/{id}") public String editar(@PathVariable Long id, Model m) { m.addAttribute("autor", service.findById(id)); return "autores/formulario"; }
    @PostMapping("/borrar/{id}") public String borrar(@PathVariable Long id) { service.delete(id); return "redirect:/autores"; }
}
