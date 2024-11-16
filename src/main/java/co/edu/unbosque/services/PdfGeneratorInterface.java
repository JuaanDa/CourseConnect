package co.edu.unbosque.services;

import co.edu.unbosque.model.dto.CursoDTO;
import co.edu.unbosque.model.dto.EstudianteDTO;


public interface PdfGeneratorInterface {
    void createPDF(String filename, CursoDTO cursoDTO, EstudianteDTO estudianteDTO);
}