package co.edu.unbosque.services;


import co.edu.unbosque.model.dao.DAO;
import co.edu.unbosque.model.dto.CursoDTO;
import co.edu.unbosque.model.dto.UsuarioDTO;
import co.edu.unbosque.model.entities.Curso;
import co.edu.unbosque.model.entities.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.modelmapper.ModelMapper;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;


@Named
@RequestScoped
public class CursoService implements CursoServiceInterface {
    @Inject
    private DAO<Curso, Integer> daoCurso;
    @Inject
    private DAO<Usuario, String> daoUsuario;
    private final ModelMapper dataMapper;

    public CursoService() {
        dataMapper = new ModelMapper();
        dataMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(PRIVATE);

    }

    @Override
    public void saveCurse(CursoDTO cursoDTO) {

        Curso  curso = dataMapper.map(cursoDTO, Curso.class);
        daoCurso.save(curso);
        dataMapper.map(cursoDTO, Curso.class);
        }

    @Override
    public CursoDTO getCurso(int id) {
        Curso curso = daoCurso.find(id);
        return dataMapper.map(curso, CursoDTO.class);
    }

    @Override
    public List<CursoDTO> getAllCursos() {
        List<Curso> cursos = daoCurso.findAll();
        List<CursoDTO> cursoDTOs = new ArrayList<>();
        for (Curso curso : cursos) {
            cursoDTOs.add(dataMapper.map(curso, CursoDTO.class));
        }
        return cursoDTOs;
    }
    public List<UsuarioDTO> getAllUsuarios() {
        List<Usuario> usuarios = daoUsuario.findAll();
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioDTOs.add(dataMapper.map(usuario, UsuarioDTO.class));

        }
        return usuarioDTOs;
    }


    @Override
    public void deleteCurso(int id) {

    }

    @Override
    public void updateCurso(CursoDTO cursoDTO) {

    }

    public List<CursoDTO> FiltrarCurso(String tipoCurso, String descripcionTema, String nombreHabilidad, LocalDate fechaInicio, String modalidadCurso) {
        List<Curso> cursos = daoCurso.findAll();
        List<CursoDTO> cursoDTOs = new ArrayList<>();
        for (Curso curso : cursos) {
            boolean matches = true;
            String query = "SELECT c FROM Curso c LEFT JOIN c.tema t LEFT JOIN c.habilidad h WHERE 1=1";

            if (tipoCurso != null && !tipoCurso.isEmpty()) {
                query += " AND c.tipoCurso = :tipoCurso";
            }
            if (descripcionTema != null && !descripcionTema.isEmpty()) {
                query += " AND t.descripcionTema = :descripcionTema";
            }
            if (nombreHabilidad != null && !nombreHabilidad.isEmpty()) {
                query += " AND h.nombreHabilidad = :nombreHabilidad";
            }
            if (fechaInicio != null) {
                query += " AND c.fechaInicio = :fechaInicio";
            }
            if (modalidadCurso != null && !modalidadCurso.isEmpty()) {
                query += " AND c.modalidadCurso = :modalidadCurso";
            }
        }
        return cursoDTOs;
    }

}
