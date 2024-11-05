package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entities.Habilidad;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.List;
@Stateless
public class HabilidadDAO implements DAO<Habilidad, Integer> {
    @PersistenceContext(unitName = "CourseConnect")
    private EntityManager em;

    @Override
    public void save(Habilidad entity) {

    }

    @Override
    public void update(Habilidad entity) {

    }

    @Override
    public void delete(Habilidad entity) {

    }

    @Override
    public Habilidad find(Integer id) {
        return em.find(Habilidad.class, id);
    }

    @Override
    public List<Habilidad> findAll() {
        return em.createNamedQuery("Habilidad.findAll", Habilidad.class).getResultList();
    }

    @Override
    public List<Habilidad> findCursos(String tipo, String tema, String habilidad, LocalDate fecha, String modalidad) {
        return List.of();
    }
}
