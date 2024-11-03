package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entities.Estudiante;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class EstudianteDAO implements DAO<Estudiante, String> {
    @PersistenceContext(unitName = "CourseConnect")
    private EntityManager em;


    @Override
    public void save(Estudiante entity) {
        em.persist(entity);
    }

    @Override
    public void update(Estudiante entity) {

    }

    @Override
    public void delete(Estudiante entity) {

    }

    @Override
    public Estudiante find(String id) {
        return null;
    }

    @Override
    public List<Estudiante> findAll() {
        return em.createNamedQuery("Estudiante.findAll", Estudiante.class).getResultList();
    }

    @Override
    public List<Estudiante> findCursos(String tipo, String tema, String habilidad, LocalDate fecha, String modalidad) {
        return List.of();
    }
}
