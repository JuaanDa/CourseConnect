package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entities.ProfesoresCurso;
import co.edu.unbosque.model.entities.ProfesoresCursoId;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class ProfesorCursoDAO implements DAO<ProfesoresCurso, ProfesoresCursoId> {
    @PersistenceContext(unitName = "CourseConnect")
    private EntityManager em;

    @Override
    public void save(ProfesoresCurso entity) {

    }

    @Override
    public void update(ProfesoresCurso entity) {

    }

    @Override
    public ProfesoresCurso find(ProfesoresCursoId profesoresCursoId) {
        return em.find(ProfesoresCurso.class, profesoresCursoId);
    }

    @Override
    public List<ProfesoresCurso> findAll() {
        return em.createNamedQuery("ProfesoresCurso.findAll", ProfesoresCurso.class).getResultList();
    }

    @Override
    public List<ProfesoresCurso> findCursos(String tipo, String tema, String habilidad, LocalDate fecha, String modalidad) {
        return List.of();
    }
}
