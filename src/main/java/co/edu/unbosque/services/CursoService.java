package co.edu.unbosque.services;


import co.edu.unbosque.model.dao.DAO;
import co.edu.unbosque.model.dto.*;
import co.edu.unbosque.model.entities.*;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.modelmapper.ModelMapper;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;


@Named
@RequestScoped
public class CursoService implements CursoServiceInterface {
    @Inject
    private DAO<Curso, Integer> daoCurso;
    @Inject
    private DAO<Usuario, String> daoUsuario;
    @Inject
    private DAO<Profesor, String> daoProfesor;
    @Inject
    private DAO<Inscripcion,InscripcionId> daoInscripcion;
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
    public List<CursoDTO> getAllCursosActivos() {
        List<Curso> cursos = daoCurso.findAll();
        List<CursoDTO> cursoDTOs = new ArrayList<>();
        for (Curso curso : cursos) {
            if(curso.getEstadoCurso().equals("ACTIVO"))
                cursoDTOs.add(dataMapper.map(curso, CursoDTO.class));
        }
        return cursoDTOs;
    }

    public List<CursoDTO> getCursoPorVencer(){
        LocalDate fechaCorte = LocalDate.of(2024, 4, 30);
        LocalDate fechaLimite = fechaCorte.minusDays(30);

        List<Curso> cursos = daoCurso.findAll();
        List<CursoDTO> cursoDTOs = new ArrayList<>();
        for (Curso curso : cursos) {
            if (!curso.getFechaFin().isBefore(fechaLimite) && !curso.getFechaFin().isAfter(fechaCorte)) {
                cursoDTOs.add(dataMapper.map(curso, CursoDTO.class));
            }
        }
            return cursoDTOs;
    }
    public List<CursoDTO> getCursosMasVendidos() {
        List<Inscripcion> inscripciones = daoInscripcion.findAll();
        Map<Integer, Integer> cursoInscripcionCount = new HashMap<>();

        for (Inscripcion inscripcion : inscripciones) {
            int cursoId = inscripcion.getIdCurso();
            cursoInscripcionCount.put(cursoId, cursoInscripcionCount.getOrDefault(cursoId, 0) + 1);
        }

        List<Curso> cursosMasVendidos = new ArrayList<>();
        for (Integer cursoId : cursoInscripcionCount.keySet()) {
            Curso curso = daoCurso.find(cursoId);
            if (curso != null) {
                cursosMasVendidos.add(curso);
            }
        }

            cursosMasVendidos.sort((curso1, curso2) -> {
            long count1 = cursoInscripcionCount.get(curso1.getId_curso());
            long count2 = cursoInscripcionCount.get(curso2.getId_curso());
            return Long.compare(count2, count1);
        });
        List<CursoDTO> cursoDTOs = new ArrayList<>();
        for (Curso curso : cursosMasVendidos) {
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
    public void updateCurso(CursoDTO cursoDTO) {

        Curso curso = dataMapper.map(cursoDTO, Curso.class);

        daoCurso.update(curso);
    }
    public List<CursoDTO> getCursos(String tipo, String tema, String habilidad, LocalDate fecha, String modalidad) {
        List<Curso> cursos = daoCurso.findCursos(tipo, tema, habilidad, fecha, modalidad);
        List<CursoDTO> cursoDTOs = new ArrayList<>();
        for (Curso curso : cursos) {
            cursoDTOs.add(dataMapper.map(curso, CursoDTO.class));
        }
        return cursoDTOs;
    }


}
