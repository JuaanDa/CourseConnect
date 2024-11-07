package co.edu.unbosque.services;

import co.edu.unbosque.model.dao.DAO;
import co.edu.unbosque.model.dao.TemasCursoDAO;
import co.edu.unbosque.model.dto.TemaDTO;
import co.edu.unbosque.model.entities.Curso;
import co.edu.unbosque.model.entities.Tema;
import co.edu.unbosque.model.entities.TemasCurso;
import co.edu.unbosque.model.entities.TemasCursoId;
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
    @Inject
    private DAO<Curso, Integer> daoCurso;
    @Inject
    private DAO<TemasCursoId, TemasCursoId> daotemaCurso;


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

    @Override
    public void updateTema(TemaDTO temaDTO) {
        Tema tema = dataMapper.map(temaDTO, Tema.class);
        daoTema.update(tema);
    }
   

    public TemaDTO getTemaPorCurso(int cursoId) {
        List<TemaDTO> temasDTO = new ArrayList<>();
        List<Curso> cursos = daoCurso.findAll(); // O usa una consulta personalizada si es necesario
        for (Curso curso : cursos) {
            if (curso.getId_curso() == cursoId) {
                for (TemasCurso temasCurso : curso.getTemasCurso()) {
                    Tema tema = temasCurso.getTema();
                    temasDTO.add(dataMapper.map(tema, TemaDTO.class));
                }
            }
        }

        // Si no hay temas, devuelve null
        return temasDTO.isEmpty() ? null : temasDTO.get(0); // Retorna el primer tema si existe, de lo contrario null
    }



}
