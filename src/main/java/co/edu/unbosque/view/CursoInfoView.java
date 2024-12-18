package co.edu.unbosque.view;

import co.edu.unbosque.model.dto.*;
import co.edu.unbosque.model.entities.CalificacionesCursoId;
import co.edu.unbosque.model.entities.InscripcionId;
import co.edu.unbosque.services.*;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("cursoInfoView")
@ViewScoped
public class CursoInfoView implements Serializable {

    private CursoDTO cursoDTO;
    private TemaDTO temaDTO;
    private CalificacionesCursoDTO calificacionesCursoDTO;
    private ArrayList<ProfesorDTO> profesores;
    private ArrayList<ProfesorCursoDTO> profesoresRol;
    private ArrayList<EstudianteDTO> estudiantes;
    private ArrayList<HabilidadDTO> habilidades;
    private ArrayList<UsuarioDTO> usuarios;
    private ProfesorCursoDTO profesorCursoDTO;
    private ArrayList<CalificacionesCursoDTO> calificaciones;
    @Inject
    private CursoService cursoService;
    @Inject
    private EstudianteService estudianteService;
    @Inject
    private TemaService temaService;
    @Inject
    private HabilidadesService habilidadesService;
    @Inject
    private CalificacionesService calificacionesService;
    private int cursoId;

    @Inject
    private ProfesoresService profesoresService;

    public CursoInfoView() {
        cursoDTO = new CursoDTO();
        temaDTO = new TemaDTO();
        calificacionesCursoDTO = new CalificacionesCursoDTO();
    }
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        cursoId = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("cursoId"));
        cursoDTO = cursoService.getCurso(cursoId);
        profesores = (ArrayList<ProfesorDTO>) profesoresService.getProfesorPorCurso(cursoId);
        profesoresRol = (ArrayList<ProfesorCursoDTO>) profesoresService.getRolProfesorPorCurso(cursoId);
        estudiantes = (ArrayList<EstudianteDTO>) estudianteService.getAllStudents();
        temaDTO = temaService.getTemaPorCurso(cursoId);
        habilidades = (ArrayList<HabilidadDTO>) habilidadesService.getHabilidadPorCurso(cursoId);
        usuarios = (ArrayList<UsuarioDTO>) cursoService.getAllUsuarios();
        calificaciones = (ArrayList<CalificacionesCursoDTO>) calificacionesService.getAllCalificacionPorCurso(cursoId);

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

    public CalificacionesCursoDTO getCalificacionesCursoDTO() {
        return calificacionesCursoDTO;
    }

    public void setCalificacionesCursoDTO(CalificacionesCursoDTO calificacionesCursoDTO) {
        this.calificacionesCursoDTO = calificacionesCursoDTO;
    }

    public ProfesorCursoDTO getProfesorCursoDTO() {
        return profesorCursoDTO;
    }

    public void setProfesorCursoDTO(ProfesorCursoDTO profesorCursoDTO) {
        this.profesorCursoDTO = profesorCursoDTO;
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

    public ArrayList<ProfesorCursoDTO> getProfesoresRol() {
        return profesoresRol;
    }

    public void setProfesoresRol(ArrayList<ProfesorCursoDTO> profesoresRol) {
        this.profesoresRol = profesoresRol;
    }

    public void setEstudiantes(ArrayList<EstudianteDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }



    public List<HabilidadDTO> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<HabilidadDTO> habilidades) {
        this.habilidades = habilidades;
    }

    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

    public List<CalificacionesCursoDTO> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ArrayList<CalificacionesCursoDTO> calificaciones) {
        this.calificaciones = calificaciones;
    }


    public String createComentario(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Comentario Correctamente Publicado"));
         calificacionesService.saveComentario(calificacionesCursoDTO);
        return null;
    }
}
