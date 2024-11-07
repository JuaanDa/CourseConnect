package co.edu.unbosque.view;


import co.edu.unbosque.model.dto.*;
import co.edu.unbosque.model.entities.CalificacionesCursoId;
import co.edu.unbosque.model.entities.InscripcionId;
import co.edu.unbosque.model.entities.TemasCurso;
import co.edu.unbosque.model.entities.TemasCursoId;
import co.edu.unbosque.services.CalificacionesService;
import co.edu.unbosque.services.CursoService;
import co.edu.unbosque.services.InscripcionService;
import co.edu.unbosque.services.TemaService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("adminView")
@ViewScoped
public class AdminView implements Serializable {
    @Inject
    private  CursoService cursoService;
    private CursoDTO cursoDTO;
    private TemaDTO temaDTO;
    private InscripcionDTO inscripcionDTO;
    private CalificacionesCursoDTO calificacionesCursoDTO;
    private boolean showDashboardPanel, showCrearCurso, showModificarCurso, showModificarPrecio, showModificarModalidades, showGestionarinscripcion, showEstudiantesInscritos, showCursoPorVencer, showFinalizarCurso;
    private int CursoId;
    private String EstudianteId;
    private TemasCursoId temasCursoId;
    @Inject
    private InscripcionView inscripcionView;
    @Named
    @Inject
    private InscripcionService inscripcionService;
    @Named
    @Inject
    private CalificacionesService calificacionesService;
    @Named
    @Inject
    private TemaService temaService;


    public AdminView(){
        cursoDTO = new CursoDTO();
        temaDTO = new TemaDTO();
        inscripcionDTO = new InscripcionDTO();
        temasCursoId = new TemasCursoId();
        calificacionesCursoDTO = new CalificacionesCursoDTO();
        showDashboardPanel = true;

    }


    public void dashboard(){
        hideAllPanels();
        showDashboardPanel = true;
    }
    public void crearCurso(){
        hideAllPanels();
        showCrearCurso = true;
    }
    public void modificarCurso(){
        hideAllPanels();
        showModificarCurso = true;

    }
    public void modificarPrecio(){
        hideAllPanels();
        showModificarPrecio = true;
    }
    public void modificarModalidades(){
        hideAllPanels();
        showModificarModalidades = true;
    }
    public void gestionarinscripcion(){
        hideAllPanels();
        showGestionarinscripcion = true;
    }
    public void estudiantesInscritos(){
        hideAllPanels();
        showEstudiantesInscritos = true;
    }
    public void cursosPorVencer(){
        hideAllPanels();
        showCursoPorVencer = true;
    }
    public void finalizarCurso(){
        hideAllPanels();
        showFinalizarCurso = true;
    }


    public boolean isShowDashboardPanel() {
        return showDashboardPanel;
    }

    public void setShowDashboardPanel(boolean showDashboardPanel) {
        this.showDashboardPanel = showDashboardPanel;
    }

    public boolean isShowCrearCurso() {
        return showCrearCurso;
    }

    public void setShowCrearCurso(boolean showCrearCurso) {
        this.showCrearCurso = showCrearCurso;
    }

    public boolean isShowModificarCurso() {
        return showModificarCurso;
    }

    public void setShowModificarCurso(boolean showModificarCurso) {
        this.showModificarCurso = showModificarCurso;
    }

    public boolean isShowModificarPrecio() {
        return showModificarPrecio;
    }

    public void setShowModificarPrecio(boolean showModificarPrecio) {
        this.showModificarPrecio = showModificarPrecio;
    }

    public boolean isShowModificarModalidades() {
        return showModificarModalidades;
    }

    public void setShowModificarModalidades(boolean showModificarModalidades) {
        this.showModificarModalidades = showModificarModalidades;
    }
    public boolean isShowGestionarinscripcion() {
        return showGestionarinscripcion;
    }

    public void setShowGestionarinscripcion(boolean showGestionarinscripcion) {
        this.showGestionarinscripcion = showGestionarinscripcion;
    }

    public boolean isShowEstudiantesInscritos() {
        return showEstudiantesInscritos;
    }

    public void setShowEstudiantesInscritos(boolean showEstudiantesInscritos) {
        this.showEstudiantesInscritos = showEstudiantesInscritos;
    }

    public boolean isShowCursoPorVencer() {
        return showCursoPorVencer;
    }

    public void setShowCursoPorVencer(boolean showCursoPorVencer) {
        this.showCursoPorVencer = showCursoPorVencer;
    }

    public boolean isShowFinalizarCurso() {
        return showFinalizarCurso;
    }

    public void setShowFinalizarCurso(boolean showFinalizarCurso) {
        this.showFinalizarCurso = showFinalizarCurso;
    }

    private void hideAllPanels() {
            showDashboardPanel = false;
          showCrearCurso = false;
          showModificarCurso = false;
          showModificarPrecio = false;
          showModificarModalidades = false;
          showGestionarinscripcion = false;
          showEstudiantesInscritos = false;
          showCursoPorVencer = false;
          showFinalizarCurso = false;

    }
    public void editarCurso(int idCurso){
        this.cursoDTO = cursoService.getCurso(idCurso);
        setCursoId(idCurso);

    }
    public void editarCursoPrice(int idCurso){
        cursoDTO.setCostoCurso(cursoDTO.getCostoCurso());
        this.cursoDTO = cursoService.getCurso(idCurso);
        setCursoId(idCurso);
      //  this.temaDTO = (temaService.getTemaPorCurso(idCurso));
       // TemasCursoId temasCursoId = new TemasCursoId(temaDTO.getIdTema(),idCurso);

    }
    public void editarCursoModalidades(int idCurso){
        cursoDTO.setModalidadCurso(cursoDTO.getModalidadCurso());
        this.cursoDTO = cursoService.getCurso(idCurso);
        setCursoId(idCurso);
    }
    public void finalizarCurso(int idCurso){
        cursoDTO.setEstadoCurso(cursoDTO.getEstadoCurso());
        this.cursoDTO = cursoService.getCurso(idCurso);
        setCursoId(idCurso);
        //this.temaDTO = (temaService.getTemaPorCurso(idCurso));
       // TemasCursoId temasCursoId = new TemasCursoId(idCurso,idCurso);


    }
    public void editarInscripcion(int idCurso, String idEstudiante){
        InscripcionId inscripcionId = new InscripcionId(idCurso,idEstudiante);
        inscripcionDTO.setEstadoInscripcion(inscripcionDTO.getEstadoInscripcion());
        this.inscripcionDTO = inscripcionService.getInscripcionById(inscripcionId);
         setCursoId(idCurso);
         setEstudianteId(idEstudiante);
    }

    public void crearComentario(int idCurso, String idEstudiante){
        CalificacionesCursoId calificacionesCursoId = new CalificacionesCursoId(idCurso,idEstudiante);
        calificacionesCursoDTO.setComentarios(calificacionesCursoDTO.getComentarios());
        this.calificacionesCursoDTO = calificacionesService.getCalificacionesCurso(calificacionesCursoId);
        setCursoId(idCurso);
        setEstudianteId(idEstudiante);
    }




    public int getCursoId() {
        return CursoId;
    }

    public void setCursoId(int cursoId) {
        CursoId = cursoId;
    }

    public TemasCursoId getTemasCursoId() {
        return temasCursoId;
    }

    public void setTemasCursoId(TemasCursoId temasCursoId) {
        this.temasCursoId = temasCursoId;
    }

    public String getEstudianteId() {
        return EstudianteId;
    }

    public void setEstudianteId(String estudianteId) {
        EstudianteId = estudianteId;
    }
}