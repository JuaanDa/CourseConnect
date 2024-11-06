package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.entities.Curso;
import co.edu.unbosque.model.entities.Estudiante;

public class CalificacionesCursoDTO {

    private int idCurso;
    private String idEstudiante;
    private float calificacion;
    private String comentarios;
    private Estudiante estudiante;
    private Curso curso;

    public CalificacionesCursoDTO() {

    }

    public CalificacionesCursoDTO(int idCurso, String idEstudiante, float calificacion, String comentarios, Estudiante estudiante, Curso curso) {
        this.idCurso = idCurso;
        this.idEstudiante = idEstudiante;
        this.calificacion = calificacion;
        this.comentarios = comentarios;
        this.estudiante = estudiante;
        this.curso = curso;
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

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
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
