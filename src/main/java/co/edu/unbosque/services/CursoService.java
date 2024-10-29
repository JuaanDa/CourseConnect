package co.edu.unbosque.services;


import co.edu.unbosque.model.dao.DAO;
import co.edu.unbosque.model.dto.CursoDTO;
import co.edu.unbosque.model.entities.Curso;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.modelmapper.ModelMapper;


import java.util.ArrayList;
import java.util.List;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;


@Named
@RequestScoped
public class CursoService implements CursoServiceInterface {
    @Inject
    private DAO<Curso, Integer> daoCurso;
    private final ModelMapper dataMapper;

    public CursoService() {
        dataMapper = new ModelMapper();
        dataMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(PRIVATE);

    }


    @Override
    public void save(CursoDTO cursDTO) {
        Curso curso = dataMapper.map(cursDTO, Curso.class);
        daoCurso.save(curso);
        dataMapper.map(cursDTO, Curso.class);
    }

    @Override
    public CursoDTO getCurso(int id) {
        Curso curso = daoCurso.find(id);
        return dataMapper.map(curso, CursoDTO.class);
    }

    @Override
    public List<CursoDTO> getAllCursos() {
        List<Curso> cursos = daoCurso.findAll();
        List<CursoDTO> cursoDTOs = new ArrayList<>();
        for (Curso curso : cursos) {
            cursoDTOs.add(dataMapper.map(curso, CursoDTO.class));
        }
        return cursoDTOs;
    }

    @Override
    public void deleteCurso(int id) {

    }

    @Override
    public void updateCurso(CursoDTO cursos) {

    }
}
