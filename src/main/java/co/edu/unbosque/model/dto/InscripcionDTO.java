package co.edu.unbosque.model.dto;

import java.time.LocalDate;

public class InscripcionDTO {

    private int idCurso;
    private String idEstudiante;
    private LocalDate fechaInscripcion;
    private String urlLinkConfirmacion;
    private String estadoInscripcion;
    private String codigoParaPago;
    

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
