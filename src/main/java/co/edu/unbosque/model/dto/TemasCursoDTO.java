package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.entities.Curso;
import co.edu.unbosque.model.entities.Tema;

public class TemasCursoDTO {

    private int idTema;
    private int idCurso;
    private Tema tema;
    private Curso curso;

    public TemasCursoDTO() {

    }

    public TemasCursoDTO(int idTema, int idCurso, Tema tema, Curso curso) {
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
