package co.edu.unbosque.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CALIFICACIONES_CURSO")
@IdClass(CalificacionesCursoId.class)
public class CalificacionesCurso {

    @Id
    @Column(name = "id_curso", nullable = false)
    private int idCurso;

    @Id
    @Column(name = "id_estudiante", nullable = false, length = 15)
    private String idEstudiante;

    @Column(name = "calificacion", nullable = false)
    private float calificacion;

    @Column(name = "comentarios", nullable = false, length = 255)
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", insertable = false, updatable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_curso", insertable = false, updatable = false)
    private Curso curso;

    public CalificacionesCurso() {

    }

    public CalificacionesCurso(int idCurso, String idEstudiante, float calificacion, String comentarios, Estudiante estudiante, Curso curso) {
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