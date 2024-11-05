package co.edu.unbosque.services;

import co.edu.unbosque.model.dto.ProfesorDTO;

import java.util.List;

public interface ProfesoresServiceInterface {
    ProfesorDTO getProfesor(String id);
    List<ProfesorDTO> getAllProfesores();
}
