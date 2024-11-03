package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entities.Curso;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class CursoDAO implements DAO<Curso, Integer>{

    @PersistenceContext(unitName = "CourseConnect")
    private EntityManager em;

    @Override
    public void save(Curso entity) {
        em.persist(entity);
    }

    @Override
    public void update(Curso entity) {

    }

    @Override
    public void delete(Curso entity) {

    }

    @Override
    public Curso find(Integer id) {
        return em.find(Curso.class, id);
    }

    @Override
    public List<Curso> findAll() {
        return em.createNamedQuery("Curso.findAll", Curso.class).getResultList();
    }

    @Override
    public List<Curso> findCursos(String tipo, String tema, String habilidad, LocalDate fecha, String modalidad) {
        TypedQuery<Curso> query = em.createNamedQuery("Curso.findByFilters", Curso.class);
        query.setParameter("tipo", tipo);
        query.setParameter("tema", tema);
        query.setParameter("habilidad", habilidad);
        query.setParameter("fecha", fecha);
        query.setParameter("modalidad", modalidad);
        return query.getResultList();    }


}
