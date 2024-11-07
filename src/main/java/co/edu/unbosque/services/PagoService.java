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
    private DAO<PagoInscripcion, Integer> daoPagoInscripcion;

    private final ModelMapper dataMapper;
    private final ObjectMapper objectMapper;

    public PagoService() {

        this.dataMapper = new ModelMapper();
        this.objectMapper = new ObjectMapper();
        dataMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(PRIVATE);
    }



    @Override
    public String procesarPago(PagoInscripcionDTO pagoInscripcionDTO) {
        try {
            // Convertir el DTO a JSON
            String jsonInput = objectMapper.writeValueAsString(pagoInscripcionDTO); // Conversión a JSON
            // Llamamos a la API para procesar el pago
            String response = apiClient.realizarPago(jsonInput); // Llama a la API con el JSON

            // Mapeamos el DTO a la entidad y lo guardamos en la base de datos
            PagoInscripcion pagoInscripcion = dataMapper.map(pagoInscripcionDTO, PagoInscripcion.class);
            daoPagoInscripcion.save(pagoInscripcion); // Guardar el pago en la base de datos

            return "Respuesta de la API: " + response;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error procesando el pago: " + e.getMessage(); // Mensaje de error más descriptivo
        }
    }

    @Override
    public List<PagoInscripcionDTO> obtenerPagos() {
        List<PagoInscripcion> pagos = daoPagoInscripcion.findAll(); // Metodo para obtener todos los pagos
        List<PagoInscripcionDTO> pagoDTOs = new ArrayList<>();

        for (PagoInscripcion pago : pagos) {
            PagoInscripcionDTO dto = dataMapper.map(pago, PagoInscripcionDTO.class);
            pagoDTOs.add(dto);
        }
        return pagoDTOs;
    }

    @Override
    public PagoInscripcionDTO obtenerPagoPorId(int id) {
        PagoInscripcion pago = daoPagoInscripcion.find(id); // Metodo para encontrar un pago por ID
        return dataMapper.map(pago, PagoInscripcionDTO.class);
    }
}
