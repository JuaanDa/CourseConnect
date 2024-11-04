package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entities.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class UsuarioDAO implements DAO<Usuario, String>  {

    @PersistenceContext(unitName = "CourseConnect")
    private EntityManager em;

    @Override
    public void save(Usuario entity) {
    em.persist(entity);
    }

    @Override
    public void update(Usuario entity) {

    }

    @Override
    public void delete(Usuario entity) {

    }

    @Override
    public Usuario find(String id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> findAll() {
        return em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
    }

    @Override
    public List<Usuario> findCursos(String tipo, String tema, String habilidad, LocalDate fecha, String modalidad) {
        return List.of();
    }




}
