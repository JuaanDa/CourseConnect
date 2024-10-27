package co.edu.unbosque.model.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "TEMAS_CURSO")
//@IdClass(TemasCursoId.class)
public class TemasCurso {

    @Id
    @Column(name = "id_tema", nullable = false)
    private int idTema;

    @Id
    @Column(name = "id_curso", nullable = false)
    private int idCurso;

    @ManyToOne
    @JoinColumn(name = "id_tema", insertable = false, updatable = false)
    private Tema tema;

    @ManyToOne
    @JoinColumn(name = "id_curso", insertable = false, updatable = false)
    private Curso curso;

    public TemasCurso() {

    }
    public TemasCurso(int idTema, int idCurso, Tema tema, Curso curso) {
        this.idTema = idTema;
        this.idCurso = idCurso;
        this.tema = tema;
        this.curso = curso;
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

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}