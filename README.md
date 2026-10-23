# Biblioteca Spring MVC

Aplicación web de gestión de una biblioteca desarrollada con Spring Boot, Spring MVC, Thymeleaf, Hibernate/JPA y H2.

## Ejecución

Requisitos: JDK 17 o superior y Maven 3.9+.

```bash
mvn clean test package
java -jar target/biblioteca-spring-mvc.jar
```

Abrir `http://localhost:8080`. La base de datos H2 en memoria se crea con `schema.sql` y se carga con `data.sql` en cada arranque. La consola H2 está disponible en `http://localhost:8080/h2-console` con JDBC URL `jdbc:h2:mem:biblioteca`, usuario `sa` y contraseña vacía.

## Arquitectura

Los controladores reciben las peticiones, los servicios encapsulan la lógica y los repositorios Spring Data JPA ejecutan el CRUD sobre Hibernate. `Autor` tiene una relación uno-a-muchos con `Libro`; al borrar un autor se borran sus libros por cascada.

## Rutas principales

| Ruta | Función |
|---|---|
| `/libros` | Listado de libros |
| `/libros/nuevo` | Alta de libro |
| `/libros/editar/{id}` | Edición |
| `/libros/borrar/{id}` | Borrado |
| `/autores` | Listado de autores |
| `/autores/nuevo` | Alta de autor |

La memoria entregable está en [`docs/memoria.html`](docs/memoria.html) y el PDF generado en `docs/memoria.pdf`.
