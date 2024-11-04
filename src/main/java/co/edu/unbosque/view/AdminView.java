package co.edu.unbosque.view;


import co.edu.unbosque.model.dto.CursoDTO;
import co.edu.unbosque.services.CursoService;
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
    private boolean showDashboardPanel, showCrearCurso, showModificarCurso;


    public AdminView(){
        cursoDTO = new CursoDTO();
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

    private void hideAllPanels() {
        showDashboardPanel = false;
          showCrearCurso = false;
          showModificarCurso = false;

    }
    public void editarCurso(int idCurso){
        System.out.println("Editando curso");
        System.out.println("idCurso: " + idCurso);
        this.cursoDTO = cursoService.getCurso(idCurso);
    }
}