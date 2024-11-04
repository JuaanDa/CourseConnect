package co.edu.unbosque.services;

import co.edu.unbosque.model.dto.CursoDTO;

import java.util.List;

public interface CursoServiceInterface {
        void saveCurse(CursoDTO curso);
        CursoDTO getCurso(int id);
        List<CursoDTO> getAllCursos();
        void deleteCurso(int id);
        void updateCurso(CursoDTO curso);
        
}
