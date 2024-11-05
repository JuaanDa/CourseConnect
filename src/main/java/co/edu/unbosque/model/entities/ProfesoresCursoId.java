package co.edu.unbosque.model.entities;

import java.io.Serializable;

public class ProfesoresCursoId implements Serializable {
    private int idCurso;
    private String idDocente;
    public ProfesoresCursoId() {

    }

    public ProfesoresCursoId(int idCurso, String idDocente) {
        this.idCurso = idCurso;
        this.idDocente = idDocente;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(String idDocente) {
        this.idDocente = idDocente;
    }
}
