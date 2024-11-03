package co.edu.unbosque.view;

import co.edu.unbosque.model.dto.*;
import co.edu.unbosque.services.CursoService;
import co.edu.unbosque.services.InscripcionService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("cursoInfoView")
@RequestScoped
public class CursoInfoView implements Serializable {

    private CursoDTO cursoDTO;
    private TemaDTO temaDTO;
    private ArrayList<ProfesorDTO> profesores;
    private ArrayList<EstudianteDTO> estudiantes;
    @Inject
    private CursoService cursoService;

    private int cursoId;

    public CursoInfoView() {
        cursoDTO = new CursoDTO();
        temaDTO = new TemaDTO();
    }
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        cursoId = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("cursoId"));
        cursoDTO = cursoService.getCurso(cursoId);
        profesores = (ArrayList<ProfesorDTO>) cursoService.getAllProfesores();
        estudiantes = (ArrayList<EstudianteDTO>) cursoService.getAllEstudiantes();

    }

    public CursoDTO getCursoDTO() {
        return cursoDTO;
    }

    public void setCursoDTO(CursoDTO cursoDTO) {
        this.cursoDTO = cursoDTO;
    }

    public TemaDTO getTemaDTO() {
        return temaDTO;
    }

    public void setTemaDTO(TemaDTO temaDTO) {
        this.temaDTO = temaDTO;
    }

    public List<ProfesorDTO> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<ProfesorDTO> profesores) {
        this.profesores = profesores;
    }
    public List<EstudianteDTO> getEstudiantes() {
        return estudiantes;
    }
    public void setEstudiantes(ArrayList<EstudianteDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }

}
