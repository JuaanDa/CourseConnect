package co.edu.unbosque.model.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "PAGO_INSCRIPCIONES")
public class PagoInscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago_inscripcion", nullable = false)
    private int idPagoInscripcion;

    @Column(name = "id_curso", nullable = false)
    private int idCurso;

    @Column(name = "id_estudiante", nullable = false, length = 15)
    private String idEstudiante;

    @Column(name = "medio_pago", nullable = false, length = 15)
    private String medioPago;

    @Column(name = "valor_pago", nullable = false)
    private int valorPago;

    @Column(name = "estado_pago", nullable = false, length = 15)
    private String estadoPago;

    public PagoInscripcion() {

    }

    public PagoInscripcion(int idPagoInscripcion, int idCurso, String idEstudiante, String medioPago, int valorPago, String estadoPago) {
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