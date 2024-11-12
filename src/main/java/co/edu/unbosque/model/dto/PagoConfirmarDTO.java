package co.edu.unbosque.model.dto;

public class PagoConfirmarDTO {
    private int tarjetaCredito;
    private String codigo;

    public PagoConfirmarDTO() {

    }
    public PagoConfirmarDTO(int tarjetaCredito, String codigo) {
        this.tarjetaCredito = tarjetaCredito;
        this.codigo = codigo;
    }

    public int getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(int tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}