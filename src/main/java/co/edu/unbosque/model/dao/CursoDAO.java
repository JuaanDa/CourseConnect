package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entities.Curso;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

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

    public List<Curso> findByTipo(String tipoCurso) {
        TypedQuery<Curso> query = em.createNamedQuery("Curso.findByTipo", Curso.class);
        query.setParameter("tipoCurso", tipoCurso);
        return query.getResultList();
    }


}
