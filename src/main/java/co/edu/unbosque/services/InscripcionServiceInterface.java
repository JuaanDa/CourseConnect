package co.edu.unbosque.services;

import co.edu.unbosque.model.dto.InscripcionDTO;
import co.edu.unbosque.model.entities.InscripcionId;

import java.util.List;

public interface InscripcionServiceInterface {
      void saveInscripcion(InscripcionDTO inscripcionDTO);
      InscripcionDTO getInscripcionById(InscripcionId inscripcionId);
      List<InscripcionDTO> getInscripciones();
      void deleteInscripcionById(int id);
      void updateInscripcion(InscripcionDTO inscripcionDTO);

}
