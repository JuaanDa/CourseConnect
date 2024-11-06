package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entities.Tema;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class TemaDAO implements DAO<Tema, Integer>{
    @PersistenceContext(unitName = "CourseConnect")
    private EntityManager em;

    @Override
    public void save(Tema entity) {


    }

    @Override
    public void update(Tema entity) {

    }


    @Override
    public Tema find(Integer id) {
        return em.find(Tema.class, id);
    }


    @Override
    public List<Tema> findAll() {
        return em.createNamedQuery("Tema.findAll", Tema.class).getResultList();
    }

    @Override
    public List<Tema> findCursos(String tipo, String tema, String habilidad, LocalDate fecha, String modalidad) {
        return List.of();
    }


}
