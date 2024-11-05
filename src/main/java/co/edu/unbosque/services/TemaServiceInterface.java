package co.edu.unbosque.services;

import co.edu.unbosque.model.dto.TemaDTO;

import java.util.List;

public interface TemaServiceInterface {
    TemaDTO getTema(int id);
    List<TemaDTO> getAllTemas();
}
