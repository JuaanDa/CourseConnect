package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entities.TemasCurso;
import co.edu.unbosque.model.entities.TemasCursoId;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class TemasCursoDAO implements DAO<TemasCursoId, TemasCursoId> {
    @PersistenceContext(unitName = "CourseConnect")
    private EntityManager em;
    @Override
    public void save(TemasCursoId entity) {

    }

    @Override
    public void update(TemasCursoId entity) {
        TemasCursoId id = new TemasCursoId(entity.getIdTema(), entity.getIdCurso());
        TemasCurso existingTemasCurso = em.find(TemasCurso.class, id);
        System.out.println(existingTemasCurso);
    }

    @Override
    public TemasCursoId find(TemasCursoId id) {
        return em.find(TemasCursoId.class, id);
    }

    @Override
    public List<TemasCursoId> findAll() {
        return List.of();
    }

    @Override
    public List<TemasCursoId> findCursos(String tipo, String tema, String habilidad, LocalDate fecha, String modalidad) {
        return List.of();
    }
}
