package co.edu.unbosque.services;

import co.edu.unbosque.model.dao.DAO;
import co.edu.unbosque.model.dto.InscripcionDTO;
import co.edu.unbosque.model.entities.Inscripcion;
import co.edu.unbosque.model.entities.InscripcionId;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Named
@RequestScoped
public class InscripcionService implements InscripcionServiceInterface {
    @Inject
    private DAO<Inscripcion,InscripcionId> daoInscripcion;
    private final ModelMapper dataMapper;

    public InscripcionService() {
        dataMapper = new ModelMapper();
        dataMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(PRIVATE);
    }
    @Override
    public void saveInscripcion(InscripcionDTO inscripcionDTO) {
        Inscripcion inscripcion = dataMapper.map(inscripcionDTO, Inscripcion.class);
        daoInscripcion.save(inscripcion);
        dataMapper.map(inscripcionDTO, Inscripcion.class);
    }

    @Override
    public InscripcionDTO getInscripcionById(InscripcionId inscripcionId) {
        Inscripcion inscripcion = daoInscripcion.find(inscripcionId);
        return dataMapper.map(inscripcion, InscripcionDTO.class);
    }


    @Override
    public List<InscripcionDTO> getInscripciones() {
        List<Inscripcion> inscripciones = daoInscripcion.findAll();
        List<InscripcionDTO> inscripcionesDTO = new ArrayList<InscripcionDTO>();
        for (Inscripcion inscripcion : inscripciones) {
            inscripcionesDTO.add(dataMapper.map(inscripcion, InscripcionDTO.class));
        }
        return inscripcionesDTO;
    }


    @Override
    public void updateInscripcion(InscripcionDTO inscripcionDTO) {
        Inscripcion inscripcion = dataMapper.map(inscripcionDTO, Inscripcion.class);
        daoInscripcion.update(inscripcion);

    }
}
