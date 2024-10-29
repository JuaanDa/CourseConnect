package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.entities.Curso;
import co.edu.unbosque.model.entities.Profesor;

public class ProfesorCursoDTO {

    private int idCurso;
    private String idDocente;
    private String rolDocente;
    private Curso curso;
    private Profesor profesor;

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

    public String getRolDocente() {
        return rolDocente;
    }

    public void setRolDocente(String rolDocente) {
        this.rolDocente = rolDocente;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
