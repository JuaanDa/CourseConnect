package co.edu.unbosque.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "INSCRIPCIONES")
@IdClass(InscripcionId.class)
@NamedQueries({
        @NamedQuery(name="Inscripcion.findAll", query = "SELECT i FROM Inscripcion i")
})
public class Inscripcion {

    @Id
    @Column(name = "id_curso", nullable = false)
    private int idCurso;

    @Id
    @Column(name = "id_estudiante", nullable = false, length = 15)
    private String idEstudiante;

    @Column(name = "fecha_inscripcion", nullable = false)
  //  @Temporal(TemporalType.DATE)
    private LocalDate fechaInscripcion;

    @Column(name = "url_link_confirmacion", nullable = false, length = 150)
    private String urlLinkConfirmacion;

    @Column(name = "estado_inscripcion", nullable = false, length = 15)
    private String estadoInscripcion;

    @Column(name = "codigo_para_pago", nullable = false, length = 50)
    private String codigoParaPago;


    public Inscripcion() {

    }
    public Inscripcion(int idCurso, String idEstudiante, LocalDate fechaInscripcion, String urlLinkConfirmacion, String estadoInscripcion, String codigoParaPago) {
        this.idCurso = idCurso;
        this.idEstudiante = idEstudiante;
        this.fechaInscripcion = fechaInscripcion;
        this.urlLinkConfirmacion = urlLinkConfirmacion;
        this.estadoInscripcion = estadoInscripcion;
        this.codigoParaPago = codigoParaPago;
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

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getUrlLinkConfirmacion() {
        return urlLinkConfirmacion;
    }

    public void setUrlLinkConfirmacion(String urlLinkConfirmacion) {
        this.urlLinkConfirmacion = urlLinkConfirmacion;
    }

    public String getEstadoInscripcion() {
        return estadoInscripcion;
    }

    public void setEstadoInscripcion(String estadoInscripcion) {
        this.estadoInscripcion = estadoInscripcion;
    }

    public String getCodigoParaPago() {
        return codigoParaPago;
    }

    public void setCodigoParaPago(String codigoParaPago) {
        this.codigoParaPago = codigoParaPago;
    }
}