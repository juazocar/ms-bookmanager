package cl.app.repository;

import cl.app.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LibroRepository {

    private Map<Long, Libro> data = new HashMap<>();

    public List<Libro> findAll(){
        return new ArrayList<>(data.values());
    }

    public Optional<Libro> findById(Long id){
        return Optional.ofNullable(data.get(id));
    }

    public Libro save(Libro libro){
        data.put(libro.getId(), libro);
        return libro;
    }

    public void delete(Long id){
        data.remove(id);
    }

}
