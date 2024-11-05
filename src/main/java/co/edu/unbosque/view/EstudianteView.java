package co.edu.unbosque.view;

import co.edu.unbosque.model.dao.DAO;
import co.edu.unbosque.model.dto.EstudianteDTO;
import co.edu.unbosque.model.entities.Estudiante;
import co.edu.unbosque.services.CursoService;
import co.edu.unbosque.services.EstudianteService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;

@Named("estudianteView")
@RequestScoped
public class EstudianteView implements Serializable {
    private ArrayList<EstudianteDTO> estudiantes;
    @Inject
    private EstudianteService estudianteService;
    private DAO<Estudiante, Integer> daoEstudiante;
    public EstudianteView() {

    }
    @PostConstruct
    public void init() {
        estudiantes = (ArrayList<EstudianteDTO>) estudianteService.getAllStudents();
    }

    public ArrayList<EstudianteDTO> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<EstudianteDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
