package cl.app.service;

import cl.app.model.Libro;
import cl.app.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LibroService {

    @Autowired
    LibroRepository libroRepository;

    public List<Libro> listar(){
        return libroRepository.findAll();
    }

    public Libro crear(Libro libro){
        return libroRepository.save(libro);
    }

    public Libro obtener(Long id){
        return libroRepository.findById(id).orElseThrow( () -> new RuntimeException("Libro no encontrado"));
    }

    public Libro actualizar(Long id, Libro libro){
        Libro existente = obtener(id);
        existente.setTitulo(libro.getTitulo());
        existente.setAutor(libro.getAutor());
        existente.setCategoria(libro.getCategoria());
        existente.setDisponible(libro.getDisponible());
        return libroRepository.save(existente);
    }

    public void eliminar(Long id){
        obtener(id);
        libroRepository.delete(id);
    }

    public List<Libro> buscarPorCategoria(String categoria){
        return libroRepository.findAll().stream().filter(l -> l.getCategoria().equalsIgnoreCase(categoria)).toList();
    }




}
