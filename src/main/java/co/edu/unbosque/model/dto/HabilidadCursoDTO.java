package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.entities.Curso;
import co.edu.unbosque.model.entities.Habilidad;

public class HabilidadCursoDTO {

    private int idCurso;
    private int idHabilidad;
    private Curso curso;
    private Habilidad habilidad;

    public HabilidadCursoDTO() {

    }

    public HabilidadCursoDTO(int idCurso, int idHabilidad, Curso curso, Habilidad habilidad) {
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
