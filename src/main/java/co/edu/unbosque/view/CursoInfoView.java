package co.edu.unbosque.view;

import co.edu.unbosque.model.dto.*;
import co.edu.unbosque.services.*;
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
    private ArrayList<TemaDTO> temas;
    private ArrayList<HabilidadDTO> habilidades;
    @Inject
    private CursoService cursoService;
    @Inject
    private EstudianteService estudianteService;
    @Inject
    private TemaService temaService;
    @Inject
    private HabilidadesService habilidadesService;
    private int cursoId;
    @Named
    @Inject
    private ProfesoresService profesoresService;

    public CursoInfoView() {
        cursoDTO = new CursoDTO();
        temaDTO = new TemaDTO();
    }
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        cursoId = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("cursoId"));
        cursoDTO = cursoService.getCurso(cursoId);
        profesores = (ArrayList<ProfesorDTO>) profesoresService.getProfesorPorCurso(cursoId);
        estudiantes = (ArrayList<EstudianteDTO>) estudianteService.getAllStudents();
        temaDTO = temaService.getTemaPorCurso(cursoId);
        habilidades = (ArrayList<HabilidadDTO>) habilidadesService.getHabilidadPorCurso(cursoId);
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

    public List<TemaDTO> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<TemaDTO> temas) {
        this.temas = temas;
    }

    public List<HabilidadDTO> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<HabilidadDTO> habilidades) {
        this.habilidades = habilidades;
    }
}
