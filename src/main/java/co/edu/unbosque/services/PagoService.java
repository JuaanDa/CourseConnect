package co.edu.unbosque.services;
import co.edu.unbosque.api.ClientPago;
import co.edu.unbosque.model.dao.DAO;
import co.edu.unbosque.model.dto.PagoInscripcionDTO;
import co.edu.unbosque.model.entities.PagoInscripcion;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.ArrayList;
import java.util.List;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Named
@RequestScoped
public class PagoService implements PagoServiceInterface{

    @Inject
    private ClientPago apiClient;
    @Inject
    private DAO<PagoInscripcion, Integer> daoPagoInscripcion;

    private final ModelMapper dataMapper;
    private final ObjectMapper objectMapper;

    public PagoService() {

        this.dataMapper = new ModelMapper();
        this.objectMapper = new ObjectMapper();
        dataMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(PRIVATE);
    }



    @Override
    public void procesarPago(PagoInscripcionDTO pagoInscripcionDTO) {
        PagoInscripcion pagoInscripcion = dataMapper.map(pagoInscripcionDTO, PagoInscripcion.class);
        daoPagoInscripcion.save(pagoInscripcion);
    }

    @Override
    public List<PagoInscripcionDTO> obtenerPagos() {
        List<PagoInscripcion> pagos = daoPagoInscripcion.findAll(); // Metodo para obtener todos los pagos
        List<PagoInscripcionDTO> pagoDTOs = new ArrayList<>();

        for (PagoInscripcion pago : pagos) {
            if(pago.getEstadoPago().equals("Confirmado"))

                pagoDTOs.add(dataMapper.map(pago, PagoInscripcionDTO.class));
        }
        return pagoDTOs;
    }
    public List<PagoInscripcionDTO> obtenerPagosPendientes() {
        List<PagoInscripcion> pagos = daoPagoInscripcion.findAll();
        List<PagoInscripcionDTO> pagoDTOs = new ArrayList<>();

        for (PagoInscripcion pago : pagos) {
            if(pago.getEstadoPago().equals("Pendiente"))
            pagoDTOs.add(dataMapper.map(pago, PagoInscripcionDTO.class));
        }
        return pagoDTOs;
    }

    @Override
    public PagoInscripcionDTO obtenerPagoPorId(int id) {
        PagoInscripcion pago = daoPagoInscripcion.find(id); // Metodo para encontrar un pago por ID
        return dataMapper.map(pago, PagoInscripcionDTO.class);
    }
}
