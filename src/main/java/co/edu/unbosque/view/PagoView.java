package co.edu.unbosque.view;

import co.edu.unbosque.model.dto.PagoInscripcionDTO;
import co.edu.unbosque.services.PagoService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;

@Named("pagoView")
@RequestScoped
public class PagoView implements Serializable {
    private PagoInscripcionDTO pagoInscripcionDTO;
    private ArrayList<PagoInscripcionDTO> pagoInscripciones;
    @Inject
    private PagoService pagoService;
    public PagoView() {
        pagoInscripcionDTO = new PagoInscripcionDTO();
    }

    @PostConstruct
    public void init() {
        pagoInscripciones = (ArrayList<PagoInscripcionDTO>)  pagoService.obtenerPagos();
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
    public String pagarInscripcion(){
        System.out.println(pagoInscripcionDTO.getMedioPago());
        return null;
    }
}

