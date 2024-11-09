package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entities.PagoInscripcion;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class PagoInscripcionDAO implements DAO<PagoInscripcion, Integer>{

    @PersistenceContext(unitName = "CourseConnect")
    private EntityManager em;

    @Override
    public void save(PagoInscripcion entity) {

    }

    @Override
    public void update(PagoInscripcion entity) {

    }

    @Override
    public PagoInscripcion find(Integer id) {
        return em.find(PagoInscripcion.class, id);
    }



    @Override
    public List<PagoInscripcion> findAll() {

        return em.createNamedQuery("PagoInscripcion.findAll", PagoInscripcion.class).getResultList();
    }

    @Override
    public List<PagoInscripcion> findCursos(String tipo, String tema, String habilidad, LocalDate fecha, String modalidad) {
        return List.of();
    }


}
