package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.entities.Curso;
import co.edu.unbosque.model.entities.Estudiante;

import java.time.LocalDate;

public class CertificadoCursoDTO {

    private int idCurso;
    private String idEstudiante;
    private LocalDate fechaExpedicionCertificado;
    private String urlDescargaCertificado;
    private Estudiante estudiante;
    private Curso curso;
    public CertificadoCursoDTO() {

    }

    public CertificadoCursoDTO(int idCurso, String idEstudiante, LocalDate fechaExpedicionCertificado, String urlDescargaCertificado, Estudiante estudiante, Curso curso) {
        this.idCurso = idCurso;
        this.idEstudiante = idEstudiante;
        this.fechaExpedicionCertificado = fechaExpedicionCertificado;
        this.urlDescargaCertificado = urlDescargaCertificado;
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

    public LocalDate getFechaExpedicionCertificado() {
        return fechaExpedicionCertificado;
    }

    public void setFechaExpedicionCertificado(LocalDate fechaExpedicionCertificado) {
        this.fechaExpedicionCertificado = fechaExpedicionCertificado;
    }

    public String getUrlDescargaCertificado() {
        return urlDescargaCertificado;
    }

    public void setUrlDescargaCertificado(String urlDescargaCertificado) {
        this.urlDescargaCertificado = urlDescargaCertificado;
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
