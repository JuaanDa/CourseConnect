package co.edu.unbosque.model.dao;

import java.time.LocalDate;
import java.util.List;

public interface DAO <T, K> {
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    T find(K id);
    List<T> findAll();

    List<T> findCursos(String tipo, String tema, String habilidad, LocalDate fecha, String modalidad);
}
