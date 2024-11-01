package co.edu.unbosque.view;

import co.edu.unbosque.model.dto.CursoDTO;
import co.edu.unbosque.model.dto.TemaDTO;
import co.edu.unbosque.services.CursoService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("cursoInfoView")
@RequestScoped
public class CursoInfoView implements Serializable {
    private CursoDTO cursoDTO;
    private TemaDTO temaDTO;
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
}
