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
import java.util.List;

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
    private DAO<Estudiante, String> daoEstudiante;
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
    public List<ProfesorDTO> getAllProfesores() {
        List<Profesor> profesores = daoProfesor.findAll();
        List<ProfesorDTO> profesorDTOs = new ArrayList<>();
        for (Profesor profesor : profesores) {
            profesorDTOs.add(dataMapper.map(profesor, ProfesorDTO.class));
        }
        return profesorDTOs;
    }
    public List<EstudianteDTO> getAllEstudiantes() {
        List<Estudiante> estudiantes = daoEstudiante.findAll();
        List<EstudianteDTO> estudianteDTOs = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            estudianteDTOs.add(dataMapper.map(estudiante, EstudianteDTO.class));
        }
        return estudianteDTOs;
    }


    @Override
    public void deleteCurso(int id) {

    }

    @Override
    public void updateCurso(CursoDTO cursoDTO) {

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
