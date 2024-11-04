package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entities.PagoInscripcion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.List;


public class PagoInscripcionDAO implements DAO<PagoInscripcion, String>{

    @PersistenceContext(unitName = "CourseConnect")
    private EntityManager em;

    @Override
    public void save(PagoInscripcion entity) {

    }

    @Override
    public void update(PagoInscripcion entity) {

    }

    @Override
    public void delete(PagoInscripcion entity) {

    }

    @Override
    public PagoInscripcion find(String id) {
        return em.find(PagoInscripcion.class, id);
    }

    @Override
    public List<PagoInscripcion> findAll() {
        return List.of();
    }

    @Override
    public List<PagoInscripcion> findCursos(String tipo, String tema, String habilidad, LocalDate fecha, String modalidad) {
        return List.of();
    }
}
