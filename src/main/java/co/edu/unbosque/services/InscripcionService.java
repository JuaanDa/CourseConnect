package co.edu.unbosque.services;

import co.edu.unbosque.model.dao.DAO;
import co.edu.unbosque.model.dto.InscripcionDTO;
import co.edu.unbosque.model.entities.Inscripcion;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Named
@RequestScoped
public class InscripcionService implements InscripcionServiceInterface {
    @Inject
    private DAO<Inscripcion,Integer> daoInscripcion;
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
    public List<InscripcionDTO> getInscripciones() {
        return List.of();
    }

    @Override
    public InscripcionDTO getInscripcionById(int id) {
        return null;
    }

    @Override
    public void deleteInscripcionById(int id) {

    }

    @Override
    public void updateInscripcion(InscripcionDTO inscripcionDTO) {

    }
}
