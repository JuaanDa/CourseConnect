package co.edu.unbosque.services;

import co.edu.unbosque.model.dao.DAO;
import co.edu.unbosque.model.dto.CalificacionesCursoDTO;
import co.edu.unbosque.model.entities.CalificacionesCurso;
import co.edu.unbosque.model.entities.CalificacionesCursoId;
import co.edu.unbosque.model.entities.Curso;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;
@Named
@RequestScoped
public class CalificacionesService implements CalificacionesServiceInterface {
    @Inject
    private DAO<CalificacionesCurso, CalificacionesCursoId> daoCalificacion;
    @Inject
    private DAO<Curso, Integer> daoCurso;
    private final ModelMapper dataMapper;
    public CalificacionesService() {
        dataMapper = new ModelMapper();
        dataMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(PRIVATE);

    }

    @Override
    public void saveComentario(CalificacionesCursoDTO calificacionesCursoDTO) {
        CalificacionesCurso calificacionesCurso = dataMapper.map(calificacionesCursoDTO, CalificacionesCurso.class);
        daoCalificacion.save(calificacionesCurso);
    }

    @Override
    public CalificacionesCursoDTO getCalificacionesCurso(CalificacionesCursoId calificacionCursoid) {
        CalificacionesCurso calificacionesCurso = daoCalificacion.find(calificacionCursoid);
        return dataMapper.map(calificacionesCurso, CalificacionesCursoDTO.class);
    }

    @Override
    public List<CalificacionesCursoDTO> getAllCalificacionesCurso() {
    List<CalificacionesCurso> calificacionesCursos = daoCalificacion.findAll();
    List<CalificacionesCursoDTO> calificacionesCursoDTOs = new ArrayList<>();
    for(CalificacionesCurso calificacionesCurso : calificacionesCursos) {
        calificacionesCursoDTOs.add(dataMapper.map(calificacionesCurso, CalificacionesCursoDTO.class));
    }
    return calificacionesCursoDTOs;
    }
    public List<CalificacionesCursoDTO> getAllCalificacionPorCurso(int cursoId) {
        List<CalificacionesCursoDTO> calificacionesCursoDTO = new ArrayList<>();
        List<Curso> cursos = daoCurso.findAll();
        for(Curso curso : cursos) {
            if(curso.getId_curso() == cursoId) {
                for(CalificacionesCurso calificacionesCurso : curso.getCalificacionesCurso()){
                    CalificacionesCursoDTO dto = new CalificacionesCursoDTO();
                    dto.setIdEstudiante(calificacionesCurso.getIdEstudiante());
                    dto.setCalificacion(calificacionesCurso.getCalificacion());
                    dto.setComentarios(calificacionesCurso.getComentarios());
                    dto.setEstudiante(calificacionesCurso.getEstudiante());
                    calificacionesCursoDTO.add(dto);

                }
            }
        }
        return calificacionesCursoDTO.isEmpty() ? null : calificacionesCursoDTO;

    }
}
