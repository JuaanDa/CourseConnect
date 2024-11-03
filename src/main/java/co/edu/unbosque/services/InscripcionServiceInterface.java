package co.edu.unbosque.services;

import co.edu.unbosque.model.dto.InscripcionDTO;

import java.util.List;

public interface InscripcionServiceInterface {
      void saveInscripcion(InscripcionDTO inscripcionDTO);
      List<InscripcionDTO> getInscripciones();
      InscripcionDTO getInscripcionById(int id);
      void deleteInscripcionById(int id);
      void updateInscripcion(InscripcionDTO inscripcionDTO);

}
