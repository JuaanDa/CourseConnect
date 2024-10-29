package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.entities.Curso;
import co.edu.unbosque.model.entities.Estudiante;

public class CursosEstudianteDTO {

    private String idEstudiante;
    private int idCurso;
    private Estudiante estudiante;
    private Curso curso;


    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
