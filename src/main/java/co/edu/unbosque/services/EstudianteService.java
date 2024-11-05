package co.edu.unbosque.services;

import co.edu.unbosque.model.dao.DAO;
import co.edu.unbosque.model.dto.EstudianteDTO;
import co.edu.unbosque.model.entities.Estudiante;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

import java.util.ArrayList;
import java.util.List;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Named
@RequestScoped
public class EstudianteService implements EstudianteServiceInterface{
    @Inject
    private DAO<Estudiante, String> daoEstudiantes;
    private final ModelMapper dataMapper;

    public EstudianteService() {
        dataMapper = new ModelMapper();
        dataMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(PRIVATE);
    }

    @Override
    public List<EstudianteDTO> getAllStudents() {
        List<Estudiante> estudiantes = daoEstudiantes.findAll();
        List<EstudianteDTO> estudianteDTOs = new ArrayList<>();
        for (Estudiante estudiante : estudiantes){
            estudianteDTOs.add(dataMapper.map(estudiante, EstudianteDTO.class));

        }
        return estudianteDTOs;
    }
}
