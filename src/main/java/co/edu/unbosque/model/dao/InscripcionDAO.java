package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entities.Inscripcion;
import co.edu.unbosque.model.entities.InscripcionId;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class InscripcionDAO implements DAO<Inscripcion, InscripcionId> {
    @PersistenceContext(unitName = "CourseConnect")
    private EntityManager em;

    @Override
    public void save(Inscripcion entity) {
        em.persist(entity);
    }

    @Override
    public void update(Inscripcion entity) {
        em.merge(entity);
    }

    @Override
    public void delete(Inscripcion entity) {

    }

    @Override
    public Inscripcion find(InscripcionId inscripcionId) {
        return em.find(Inscripcion.class, inscripcionId);
    }



    @Override
    public List<Inscripcion> findAll() {
        return em.createNamedQuery("Inscripcion.findAll", Inscripcion.class).getResultList();
    }

    @Override
    public List<Inscripcion> findCursos(String tipo, String tema, String habilidad, LocalDate fecha, String modalidad) {
        return List.of();
    }


}
