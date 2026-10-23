package es.curso.ia.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity @Table(name = "libros")
public class Libro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El título es obligatorio") @Size(max = 150, message = "Máximo 150 caracteres")
    @Column(nullable = false, length = 150) private String titulo;
    @NotBlank(message = "El ISBN es obligatorio") @Size(max = 20, message = "Máximo 20 caracteres")
    @Column(nullable = false, unique = true, length = 20) private String isbn;
    @NotNull(message = "El año es obligatorio") @Min(value = 1000, message = "Año no válido") @Max(value = 2100, message = "Año no válido")
    @Column(nullable = false) private Integer anioPublicacion;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;
    public Libro() {}
    public Libro(String titulo, String isbn, Integer anioPublicacion, Autor autor) { this.titulo=titulo; this.isbn=isbn; this.anioPublicacion=anioPublicacion; this.autor=autor; }
    public Long getId() { return id; } public void setId(Long id) { this.id=id; }
    public String getTitulo() { return titulo; } public void setTitulo(String titulo) { this.titulo=titulo; }
    public String getIsbn() { return isbn; } public void setIsbn(String isbn) { this.isbn=isbn; }
    public Integer getAnioPublicacion() { return anioPublicacion; } public void setAnioPublicacion(Integer anio) { this.anioPublicacion=anio; }
    public Autor getAutor() { return autor; } public void setAutor(Autor autor) { this.autor=autor; }
}
