package es.curso.ia.biblioteca;

import es.curso.ia.biblioteca.model.Autor;
import es.curso.ia.biblioteca.repository.AutorRepository;
import es.curso.ia.biblioteca.repository.LibroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest @AutoConfigureMockMvc class BibliotecaApplicationTests {
    @Autowired MockMvc mvc; @Autowired AutorRepository autores; @Autowired LibroRepository libros;
    @Test void cargaPaginaLibros() throws Exception { mvc.perform(get("/libros")).andExpect(status().isOk()).andExpect(content().string(containsString("Cien años de soledad"))); }
    @Test void existenDatosDePruebaRelacionados() { assertEquals(3, autores.count()); assertEquals(3, libros.count()); assertNotNull(libros.findAll().get(0).getAutor()); }
    @Test void formularioNuevoAutor() throws Exception { mvc.perform(get("/autores/nuevo")).andExpect(status().isOk()).andExpect(content().string(containsString("Nuevo autor"))); }
}
