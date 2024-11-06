package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entities.Profesor;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class ProfesorDAO implements DAO<Profesor, String> {
    @PersistenceContext(unitName = "CourseConnect")
    private EntityManager em;


    @Override
    public void save(Profesor entity) {
        em.persist(entity);

    }

    @Override
    public void update(Profesor entity) {

    }



    @Override
    public Profesor find(String id) {
        return null;
    }



    @Override
    public List<Profesor> findAll() {
        return em.createNamedQuery("Profesor.findAll", Profesor.class).getResultList();
    }

    @Override
    public List<Profesor> findCursos(String tipo, String tema, String habilidad, LocalDate fecha, String modalidad) {
        return List.of();
    }


}
