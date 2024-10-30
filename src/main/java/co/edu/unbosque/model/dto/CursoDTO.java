package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.entities.Usuario;

import java.time.LocalDate;

public class CursoDTO {

    private int id_curso;
    private String tituloCurso;
    private String urlImagenCurso;
    private String tipoCurso;
    private String modalidadCurso;
    private String horarioCurso;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int horasCurso;
    private double costoCurso;
    private String estadoCurso;
    private LocalDate fechaCreacion;
    private Usuario creadoPor;

    public CursoDTO(){

    }

    public CursoDTO(int id_curso, String tituloCurso, String urlImagenCurso, String tipoCurso, String modalidadCurso, String horarioCurso, LocalDate fechaInicio, LocalDate fechaFin, int horasCurso, double costoCurso, String estadoCurso, LocalDate fechaCreacion, Usuario creadoPor) {
        this.id_curso = id_curso;
        this.tituloCurso = tituloCurso;
        this.urlImagenCurso = urlImagenCurso;
        this.tipoCurso = tipoCurso;
        this.modalidadCurso = modalidadCurso;
        this.horarioCurso = horarioCurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horasCurso = horasCurso;
        this.costoCurso = costoCurso;
        this.estadoCurso = estadoCurso;
        this.fechaCreacion = fechaCreacion;
        this.creadoPor = creadoPor;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getTituloCurso() {
        return tituloCurso;
    }

    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }

    public String getUrlImagenCurso() {
        return urlImagenCurso;
    }

    public void setUrlImagenCurso(String urlImagenCurso) {
        this.urlImagenCurso = urlImagenCurso;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getModalidadCurso() {
        return modalidadCurso;
    }

    public void setModalidadCurso(String modalidadCurso) {
        this.modalidadCurso = modalidadCurso;
    }

    public String getHorarioCurso() {
        return horarioCurso;
    }

    public void setHorarioCurso(String horarioCurso) {
        this.horarioCurso = horarioCurso;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getHorasCurso() {
        return horasCurso;
    }

    public void setHorasCurso(int horasCurso) {
        this.horasCurso = horasCurso;
    }

    public double getCostoCurso() {
        return costoCurso;
    }

    public void setCostoCurso(double costoCurso) {
        this.costoCurso = costoCurso;
    }

    public String getEstadoCurso() {
        return estadoCurso;
    }

    public void setEstadoCurso(String estadoCurso) {
        this.estadoCurso = estadoCurso;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Usuario creadoPor) {
        this.creadoPor = creadoPor;
    }
}
