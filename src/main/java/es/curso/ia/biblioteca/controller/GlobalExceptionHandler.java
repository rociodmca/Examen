package es.curso.ia.biblioteca.controller;
import org.springframework.ui.Model; import org.springframework.web.bind.annotation.ControllerAdvice; import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice public class GlobalExceptionHandler { @ExceptionHandler(Exception.class) public String error(Exception ex, Model model) { model.addAttribute("mensaje", ex.getMessage()); return "error"; } }
