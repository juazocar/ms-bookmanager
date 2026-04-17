package cl.app.controller;

import cl.app.model.Libro;
import cl.app.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> listar(){
        return ResponseEntity.ok(libroService.listar());
    }

    @PostMapping
    public ResponseEntity<Libro> crear(@Valid @RequestBody Libro libro){
        return ResponseEntity.ok(libroService.crear(libro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtener(@PathVariable Long id){
        return ResponseEntity.ok(libroService.obtener(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Long id, @Valid @RequestBody Libro libro){
        return ResponseEntity.ok(libroService.actualizar(id, libro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        libroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categorias/{categoria}")
    public ResponseEntity<List<Libro>> buscarPorCategoria(@PathVariable String categoria){
        return ResponseEntity.ok(libroService.buscarPorCategoria(categoria));
    }
}
