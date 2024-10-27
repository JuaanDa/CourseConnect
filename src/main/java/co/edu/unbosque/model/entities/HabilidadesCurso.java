package co.edu.unbosque.model.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "HABILIDADES_CURSO")
//@IdClass(HabilidadesCursoId.class) // Clase para la clave compuesta
public class HabilidadesCurso {

    @Id
    @Column(name = "id_curso", nullable = false)
    private int idCurso;

    @Id
    @Column(name = "id_habilidad", nullable = false)
    private int idHabilidad;

    @ManyToOne
    @JoinColumn(name = "id_curso", insertable = false, updatable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_habilidad", insertable = false, updatable = false)
    private Habilidad habilidad;

    public HabilidadesCurso() {

    }

    public HabilidadesCurso(int idCurso, int idHabilidad, Curso curso, Habilidad habilidad) {
        this.idCurso = idCurso;
        this.idHabilidad = idHabilidad;
        this.curso = curso;
        this.habilidad = habilidad;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }
}