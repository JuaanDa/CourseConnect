package co.edu.unbosque.view;


import co.edu.unbosque.model.dto.CursoDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("adminView")
@ViewScoped
public class AdminView implements Serializable {
    private CursoDTO cursoDTO;
    private boolean showDashboardPanel, showCrearCurso;


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
    private void hideAllPanels() {
        showDashboardPanel = false;
          showCrearCurso = false;
    }
}