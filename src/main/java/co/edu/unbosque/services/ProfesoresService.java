package co.edu.unbosque.services;

import co.edu.unbosque.model.dao.DAO;
import co.edu.unbosque.model.dto.ProfesorCursoDTO;
import co.edu.unbosque.model.dto.ProfesorDTO;
import co.edu.unbosque.model.entities.Curso;
import co.edu.unbosque.model.entities.Profesor;
import co.edu.unbosque.model.entities.ProfesoresCurso;
import co.edu.unbosque.model.entities.ProfesoresCursoId;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Named
@RequestScoped
public class ProfesoresService implements ProfesoresServiceInterface {
    @Inject
    private DAO<Profesor, String> daoProfesor;
    @Inject
    private DAO<ProfesoresCurso, ProfesoresCursoId> daoProfesoresCurso;
    @Inject
    private DAO<Curso, Integer> daoCurso;
    private final ModelMapper dataMapper;

    public ProfesoresService() {
        dataMapper = new ModelMapper();
        dataMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(PRIVATE);

    }

    @Override
    public ProfesorDTO getProfesor(String id) {
        Profesor profesor = daoProfesor.find(id);
        return dataMapper.map(profesor, ProfesorDTO.class);
    }

    @Override
    public List<ProfesorDTO> getAllProfesores() {
        return List.of();
    }

    public List<ProfesorCursoDTO> getRolProfesorPorCurso(int cursoId) {
        List<ProfesoresCurso> profesoresRol = daoProfesoresCurso.findAll();
        List<ProfesorCursoDTO> profesoresCursoDTOs = new ArrayList<>();

        for (ProfesoresCurso profesorCurso : profesoresRol) {
            if (profesorCurso.getCurso().getId_curso() == cursoId) {
                ProfesorCursoDTO profesorCursoDTO = dataMapper.map(profesorCurso, ProfesorCursoDTO.class);
                profesorCursoDTO.setRolDocente(profesorCurso.getRolDocente());
                profesoresCursoDTOs.add(profesorCursoDTO);
            }
        }

        return profesoresCursoDTOs.isEmpty() ? null : profesoresCursoDTOs;
    }

    public List<ProfesorDTO> getProfesorPorCurso(int cursoId) {
        List<ProfesorDTO> profesoresDTO = new ArrayList<>();
        List<Curso> cursos = daoCurso.findAll();
        for (Curso curso : cursos) {
            if (curso.getId_curso() == cursoId) {
                for (ProfesoresCurso profesoresCurso : curso.getProfesoresCurso()) {
                    Profesor profesor = profesoresCurso.getProfesor();
                    profesoresDTO.add(dataMapper.map(profesor, ProfesorDTO.class));
                }
            }
        }
        return profesoresDTO.isEmpty() ? null : profesoresDTO;
    }
}