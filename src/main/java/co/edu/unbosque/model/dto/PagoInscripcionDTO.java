package co.edu.unbosque.model.dto;

public class PagoInscripcionDTO {

    private int idPagoInscripcion;
    private int idCurso;
    private String idEstudiante;
    private String medioPago;
    private int valorPago;
    private String estadoPago;

    public PagoInscripcionDTO() {

    }

    public PagoInscripcionDTO(int idPagoInscripcion, int idCurso, String idEstudiante, String medioPago, int valorPago, String estadoPago) {
        this.idPagoInscripcion = idPagoInscripcion;
        this.idCurso = idCurso;
        this.idEstudiante = idEstudiante;
        this.medioPago = medioPago;
        this.valorPago = valorPago;
        this.estadoPago = estadoPago;
    }

    public int getIdPagoInscripcion() {
        return idPagoInscripcion;
    }

    public void setIdPagoInscripcion(int idPagoInscripcion) {
        this.idPagoInscripcion = idPagoInscripcion;
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

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public int getValorPago() {
        return valorPago;
    }

    public void setValorPago(int valorPago) {
        this.valorPago = valorPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }
}
