package co.edu.unbosque.services;

import co.edu.unbosque.model.dao.DAO;
import co.edu.unbosque.model.dto.TemaDTO;
import co.edu.unbosque.model.entities.Tema;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Named
@RequestScoped
public class TemaService implements TemaServiceInterface {
    @Inject
    private DAO<Tema, Integer> daoTema;

    private final ModelMapper dataMapper;
    public TemaService() {
        dataMapper = new ModelMapper();
        dataMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(PRIVATE);
    }
    @Override
    public TemaDTO getTema(int id) {
        Tema tema = daoTema.find(id);
        return dataMapper.map(tema, TemaDTO.class);
    }

    @Override
    public List<TemaDTO> getAllTemas() {
        List<Tema> temas = daoTema.findAll();
        List<TemaDTO> temasDTO = new ArrayList<>();
        for (Tema tema : temas) {
            temasDTO.add(dataMapper.map(tema, TemaDTO.class));
        }
        return temasDTO;
    }
}
