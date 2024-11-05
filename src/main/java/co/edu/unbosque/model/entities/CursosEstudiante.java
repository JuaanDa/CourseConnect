package co.edu.unbosque.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CURSOS_ESTUDIANTE")
@IdClass(CursosEstudianteId.class)
public class CursosEstudiante {

    @Id
    @Column(name = "id_estudiante", nullable = false, length = 15)
    private String idEstudiante;

    @Id
    @Column(name = "id_curso", nullable = false)
    private int idCurso;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", insertable = false, updatable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_curso", insertable = false, updatable = false)
    private Curso curso;

    public CursosEstudiante() {

    }

    public CursosEstudiante(String idEstudiante, int idCurso, Estudiante estudiante, Curso curso) {
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
        this.estudiante = estudiante;
        this.curso = curso;
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
