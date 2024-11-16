package co.edu.unbosque.services;

import co.edu.unbosque.model.dto.EstudianteDTO;

import java.util.List;

public interface EstudianteServiceInterface {
    List<EstudianteDTO> getAllStudents();
    EstudianteDTO getStudentById(String id);
}
