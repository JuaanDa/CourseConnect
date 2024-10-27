package co.edu.unbosque.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
public class CertificadoCurso {

    @Id
    @Column(name = "id_curso", nullable = false)
    private int idCurso;

    @Id
    @Column(name = "id_estudiante", nullable = false, length = 15)
    private String idEstudiante;

    @Column(name = "fecha_expedicion_certificado", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fechaExpedicionCertificado;

    @Column(name = "url_descarga_certificado", nullable = false, length = 150)
    private String urlDescargaCertificado;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", insertable = false, updatable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_curso", insertable = false, updatable = false)
    private Curso curso;

    public CertificadoCurso() {

    }

    public CertificadoCurso(int idCurso, String idEstudiante, LocalDate fechaExpedicionCertificado, String urlDescargaCertificado, Estudiante estudiante, Curso curso) {
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