package co.edu.unbosque.model.entities;

import java.io.Serializable;

public class CursosEstudianteId implements Serializable {
    private String idEstudiante;
    private int idCurso;

    public CursosEstudianteId() {

    }

    public CursosEstudianteId(String idEstudiante, int idCurso) {
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
    }

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
}