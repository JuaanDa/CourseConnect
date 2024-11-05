package co.edu.unbosque.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PROFESORES_CURSO")
@IdClass(ProfesoresCursoId.class)
public class ProfesoresCurso {

    @Id
    @Column(name = "id_curso", nullable = false)
    private int idCurso;

    @Id
    @Column(name = "id_docente", nullable = false, length = 15)
    private String idDocente;

    @Column(name = "rol_docente", nullable = false, length = 15)
    private String rolDocente;

    @ManyToOne
    @JoinColumn(name = "id_curso", insertable = false, updatable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_docente", insertable = false, updatable = false)
    private Profesor profesor;

    public ProfesoresCurso() {

    }

    public ProfesoresCurso(int idCurso, String idDocente, String rolDocente, Curso curso, Profesor profesor) {
        this.idCurso = idCurso;
        this.idDocente = idDocente;
        this.rolDocente = rolDocente;
        this.curso = curso;
        this.profesor = profesor;
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
