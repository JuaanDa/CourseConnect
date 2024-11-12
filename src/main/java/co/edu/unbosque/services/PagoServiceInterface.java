package co.edu.unbosque.services;

import co.edu.unbosque.model.dto.PagoInscripcionDTO;

import java.util.List;

public interface PagoServiceInterface {
    void procesarPago(PagoInscripcionDTO pagoInscripcionDTO);
    List<PagoInscripcionDTO> obtenerPagos();
    PagoInscripcionDTO obtenerPagoPorId(int id);
}