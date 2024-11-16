package co.edu.unbosque.view;

import co.edu.unbosque.api.ClientEmail;
import co.edu.unbosque.api.ClientPago;
import co.edu.unbosque.model.dto.PagoConfirmarDTO;
import co.edu.unbosque.model.dto.PagoInscripcionDTO;
import co.edu.unbosque.services.PagoService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.hibernate.internal.build.AllowSysOut;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Named("pagoView")
@RequestScoped
public class PagoView implements Serializable {
    private PagoInscripcionDTO pagoInscripcionDTO;
    private PagoConfirmarDTO confirmarDTO;
    private ArrayList<PagoInscripcionDTO> pagoInscripciones;
    private ArrayList<PagoInscripcionDTO> pagosPendientes;
    @Inject
    private PagoService pagoService;
    @Inject
    private ClientPago clientPago;

    public PagoView() {
        pagoInscripcionDTO = new PagoInscripcionDTO();
        confirmarDTO = new PagoConfirmarDTO();
    }

    @PostConstruct
    public void init() {
        pagoInscripciones = (ArrayList<PagoInscripcionDTO>) pagoService.obtenerPagos();
        pagosPendientes = (ArrayList<PagoInscripcionDTO>) pagoService.obtenerPagosPendientes();
        pagoInscripcionDTO.setMedioPago("TarjetaCredito");
        pagoInscripcionDTO.setEstadoPago("Pendiente");
        confirmarDTO.setTarjetaCredito(50200800);

    }

    public PagoInscripcionDTO getPagoInscripcionDTO() {
        return pagoInscripcionDTO;
    }

    public void setPagoInscripcionDTO(PagoInscripcionDTO pagoInscripcionDTO) {
        this.pagoInscripcionDTO = pagoInscripcionDTO;
    }

    public PagoConfirmarDTO getConfirmarDTO() {
        return confirmarDTO;
    }

    public void setConfirmarDTO(PagoConfirmarDTO confirmarDTO) {
        this.confirmarDTO = confirmarDTO;
    }

    public ArrayList<PagoInscripcionDTO> getPagoInscripciones() {
        return pagoInscripciones;
    }

    public void setPagoInscripciones(ArrayList<PagoInscripcionDTO> pagoInscripciones) {
        this.pagoInscripciones = pagoInscripciones;
    }

    public ArrayList<PagoInscripcionDTO> getPagosPendientes() {
        return pagosPendientes;
    }

    public void setPagosPendientes(ArrayList<PagoInscripcionDTO> pagosPendientes) {
        this.pagosPendientes = pagosPendientes;
    }

    public String pagarInscripcion() {
        try {
            Map<String, String> parametros = new HashMap<>();
            parametros.put("idCurso", String.valueOf(pagoInscripcionDTO.getIdCurso()));
            parametros.put("idEstudiante", String.valueOf(pagoInscripcionDTO.getIdEstudiante()));
            parametros.put("medioPago", pagoInscripcionDTO.getMedioPago());
            parametros.put("valorPago", String.valueOf(pagoInscripcionDTO.getValorPago()));
            parametros.put("estadoPago", pagoInscripcionDTO.getEstadoPago());
            String simulacionPago = clientPago.realizarPago(parametros);
            System.out.println(simulacionPago);  // Aquí podrías imprimir la respuesta de la API
            pagoService.procesarPago(pagoInscripcionDTO);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Inscripción Correcta, Verifique su correo"));

        } catch (Exception e) {
            System.out.println("error inscripcion");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", "error en su pago, intentelo nuevamente."));
            e.printStackTrace();
            return null;
        }

        return "TarjetaDeCredito.xhtml";
    }

    public String pagarConfirmacion() throws IOException {
        try {
            Map<String, String> parametros2 = new HashMap<>();
            parametros2.put("numeroTarjeta", String.valueOf((confirmarDTO.getTarjetaCredito())));
            parametros2.put("codigo", String.valueOf(confirmarDTO.getCodigo()));
            System.out.println(confirmarDTO.getCodigo());
            confirmarDTO.setCodigo(confirmarDTO.getCodigo());
            String confirmarPago = clientPago.confirmarPago(parametros2);
            System.out.println(confirmarPago);
            pagoInscripcionDTO.setEstadoPago("Confirmado");

        } catch (Exception e){
            System.out.println("error inscripcion");
        }
                return null;

    }

}


