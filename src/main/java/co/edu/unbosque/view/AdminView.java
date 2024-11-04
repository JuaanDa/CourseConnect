package co.edu.unbosque.view;


import co.edu.unbosque.model.dto.CursoDTO;
import co.edu.unbosque.model.dto.InscripcionDTO;
import co.edu.unbosque.model.entities.InscripcionId;
import co.edu.unbosque.services.CursoService;
import co.edu.unbosque.services.InscripcionService;
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
    private InscripcionDTO inscripcionDTO;
    private boolean showDashboardPanel, showCrearCurso, showModificarCurso, showModificarPrecio, showModificarModalidades, showGestionarinscripcion;
    private int CursoId;
    private String EstudianteId;
    @Named("inscripcionView")
    @Inject
    private InscripcionView inscripcionView;
    @Named
    @Inject
    private InscripcionService inscripcionService;


    public AdminView(){
        cursoDTO = new CursoDTO();
        inscripcionDTO = new InscripcionDTO();
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

    private void hideAllPanels() {
            showDashboardPanel = false;
          showCrearCurso = false;
          showModificarCurso = false;
          showModificarPrecio = false;
          showModificarModalidades = false;
          showGestionarinscripcion = false;

    }
    public void editarCurso(int idCurso){
        this.cursoDTO = cursoService.getCurso(idCurso);
        setCursoId(idCurso); // Asignar el valor a CursoId

    }
    public void editarCursoPrice(int idCurso){
        cursoDTO.setCostoCurso(cursoDTO.getCostoCurso());
        this.cursoDTO = cursoService.getCurso(idCurso);
        setCursoId(idCurso);

    }
    public void editarCursoModalidades(int idCurso){
        cursoDTO.setModalidadCurso(cursoDTO.getModalidadCurso());
        System.out.println(cursoDTO.getModalidadCurso());
        this.cursoDTO = cursoService.getCurso(idCurso);
        setCursoId(idCurso);
    }
    public void editarInscripcion(int idCurso, String idStudiante){
        InscripcionId inscripcionId = new InscripcionId(idCurso,idStudiante);
        inscripcionDTO.setEstadoInscripcion(inscripcionDTO.getEstadoInscripcion());
        this.inscripcionDTO = inscripcionService.getInscripcionById(inscripcionId);
         setCursoId(idCurso);
         setEstudianteId(idStudiante);
    }



    public int getCursoId() {
        return CursoId;
    }

    public void setCursoId(int cursoId) {
        CursoId = cursoId;
    }

    public String getEstudianteId() {
        return EstudianteId;
    }

    public void setEstudianteId(String estudianteId) {
        EstudianteId = estudianteId;
    }
}