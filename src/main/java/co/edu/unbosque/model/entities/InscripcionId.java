package co.edu.unbosque.model.entities;

import java.io.Serializable;

public class InscripcionId implements Serializable {
    private int idCurso;
    private String idEstudiante;

    public InscripcionId() {

    }

    public InscripcionId(int idCurso, String idEstudiante) {
        this.idCurso = idCurso;
        this.idEstudiante = idEstudiante;
    }
    public int getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
    public String getIdEstudiante() {
        return idEstudiante;
    }
    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

}
