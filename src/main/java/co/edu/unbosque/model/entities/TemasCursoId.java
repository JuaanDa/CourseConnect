package co.edu.unbosque.model.entities;

import java.io.Serializable;

public class TemasCursoId implements Serializable {
    private int idTema;
    private int idCurso;
    public TemasCursoId() {

    }

    public TemasCursoId(int idTema, int idCurso) {
        this.idTema = idTema;
        this.idCurso = idCurso;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
}
