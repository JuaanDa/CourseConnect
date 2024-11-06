package co.edu.unbosque.services;

import co.edu.unbosque.model.dto.CalificacionesCursoDTO;
import co.edu.unbosque.model.entities.CalificacionesCursoId;

import java.util.List;

public interface CalificacionesServiceInterface {
    void saveComentario(CalificacionesCursoDTO calificaciones);;
    CalificacionesCursoDTO  getCalificacionesCurso(CalificacionesCursoId calificacionCursoid);
    List<CalificacionesCursoDTO> getAllCalificacionesCurso();
}
