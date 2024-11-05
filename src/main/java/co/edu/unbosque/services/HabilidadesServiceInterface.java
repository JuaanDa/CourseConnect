package co.edu.unbosque.services;

import co.edu.unbosque.model.dto.HabilidadDTO;

import java.util.List;

public interface HabilidadesServiceInterface {
    HabilidadDTO getHabilidad(int id);
    List<HabilidadDTO> getAllHabilidades();
}
