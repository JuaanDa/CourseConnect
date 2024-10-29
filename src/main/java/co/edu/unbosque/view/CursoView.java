package co.edu.unbosque.view;

import co.edu.unbosque.model.dto.CursoDTO;
import co.edu.unbosque.services.CursoService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Named("CursoView")
@RequestScoped
public class CursoView implements Serializable {
    private ArrayList<CursoDTO> cursos;
    private CursoDTO cursoDTO;

    @Inject
    private CursoService cursoService;

    @PostConstruct
    public void init() {
        cursos  = (ArrayList<CursoDTO>) cursoService.getAllCursos();
        // Imprimir los cursos obtenidos
        cursoDTO = new CursoDTO();
    }
    public CursoView(){

    }

    public CursoDTO getCursoDTO() {
        return cursoDTO;
    }

    public void setCursoDTO(CursoDTO cursoDTO) {
        this.cursoDTO = cursoDTO;
    }
    public List<CursoDTO> getCursos() {
        return cursos;
    }

}
