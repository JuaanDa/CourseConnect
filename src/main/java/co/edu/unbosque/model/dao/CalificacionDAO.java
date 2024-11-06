package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entities.CalificacionesCurso;
import co.edu.unbosque.model.entities.CalificacionesCursoId;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class CalificacionDAO implements DAO<CalificacionesCurso, CalificacionesCursoId> {
    @PersistenceContext(unitName = "CourseConnect")
    private EntityManager em;

    @Override
    public void save(CalificacionesCurso entity) {
        em.persist(entity);
    }

    @Override
    public void update(CalificacionesCurso entity) {

    }


    @Override
    public CalificacionesCurso find(CalificacionesCursoId calificacionesCursoId) {
        return em.find(CalificacionesCurso.class, calificacionesCursoId);
    }

    @Override
    public List<CalificacionesCurso> findAll() {
        return em.createNamedQuery("CalificacionesCurso.findAll", CalificacionesCurso.class).getResultList();
    }

    @Override
    public List<CalificacionesCurso> findCursos(String tipo, String tema, String habilidad, LocalDate fecha, String modalidad) {
        return List.of();
    }


}
