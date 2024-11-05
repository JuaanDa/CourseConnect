package co.edu.unbosque.model.entities;

import java.io.Serializable;

public class HabilidadesCursoId implements Serializable {
    private int idCurso;
    private int idHabilidad;
    public HabilidadesCursoId() {

    }

    public HabilidadesCursoId(int idCurso, int idHabilidad) {
        this.idCurso = idCurso;
        this.idHabilidad = idHabilidad;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(int idHabilidad) {
        this.idHabilidad = idHabilidad;
    }
}
