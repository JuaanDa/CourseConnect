package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entities.Tema;

import java.time.LocalDate;
import java.util.List;

public class TemaDAO implements DAO<Tema, String>{
    @Override
    public void save(Tema entity) {

    }

    @Override
    public void update(Tema entity) {

    }

    @Override
    public void delete(Tema entity) {

    }

    @Override
    public Tema find(String id) {
        return null;
    }

    @Override
    public List<Tema> findAll() {
        return List.of();
    }

    @Override
    public List<Tema> findCursos(String tipo, String tema, String habilidad, LocalDate fecha, String modalidad) {
        return List.of();
    }
}
