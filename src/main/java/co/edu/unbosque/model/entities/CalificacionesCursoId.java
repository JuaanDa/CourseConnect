package co.edu.unbosque.model.entities;

import java.io.Serializable;

public class CalificacionesCursoId implements Serializable {
    private int idCurso;
    private String idStudiante;
    public CalificacionesCursoId() {

    }

    public CalificacionesCursoId(int idCurso, String idStudiante) {
        this.idCurso = idCurso;
        this.idStudiante = idStudiante;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getIdStudiante() {
        return idStudiante;
    }

    public void setIdStudiante(String idStudiante) {
        this.idStudiante = idStudiante;
    }
}
