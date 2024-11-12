package co.edu.unbosque.view;

import co.edu.unbosque.model.dto.PagoInscripcionDTO;
import co.edu.unbosque.services.PagoService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;

@Named("pagoView")
@RequestScoped
public class PagoView implements Serializable {
    private PagoInscripcionDTO pagoInscripcionDTO;
    private ArrayList<PagoInscripcionDTO> pagoInscripciones;
    private ArrayList<PagoInscripcionDTO> pagosPendientes;
    @Inject
    private PagoService pagoService;
    public PagoView() {
        pagoInscripcionDTO = new PagoInscripcionDTO();
    }

    @PostConstruct
    public void init() {
        pagoInscripciones = (ArrayList<PagoInscripcionDTO>)  pagoService.obtenerPagos();
        pagosPendientes = (ArrayList<PagoInscripcionDTO>)  pagoService.obtenerPagosPendientes();
        pagoInscripcionDTO.setMedioPago("TarjetaCredito");
        pagoInscripcionDTO.setEstadoPago("Confirmado");

    }

    public PagoInscripcionDTO getPagoInscripcionDTO() {
        return pagoInscripcionDTO;
    }

    public void setPagoInscripcionDTO(PagoInscripcionDTO pagoInscripcionDTO) {
        this.pagoInscripcionDTO = pagoInscripcionDTO;
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

    public String pagarInscripcion(){
        try {
System.out.println("pago inscripcion");
        pagoService.procesarPago(pagoInscripcionDTO);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Inscripción Correcta, Verifique su correo"));

    } catch (Exception e) {
System.out.println("error inscripcion");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", "error en su pago, intentelo nuevamente."));
        e.printStackTrace();
    }

       return null;
    }
}

