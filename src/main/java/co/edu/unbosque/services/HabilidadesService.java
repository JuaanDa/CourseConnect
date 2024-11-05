package co.edu.unbosque.services;

import co.edu.unbosque.model.dao.DAO;
import co.edu.unbosque.model.dto.HabilidadDTO;
import co.edu.unbosque.model.entities.Curso;
import co.edu.unbosque.model.entities.Habilidad;
import co.edu.unbosque.model.entities.HabilidadesCurso;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Named
@RequestScoped
public class HabilidadesService implements HabilidadesServiceInterface{
    @Inject
    private DAO<Habilidad, Integer> daoHabilidad;
    @Inject
    private DAO<Curso, Integer> daoCurso;

    private final ModelMapper dataMapper;

    public HabilidadesService() {
        dataMapper = new ModelMapper();
        dataMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(PRIVATE);

    }

    @Override
    public HabilidadDTO getHabilidad(int id) {
        Habilidad habilidad = daoHabilidad.find(id);
        return dataMapper.map(habilidad, HabilidadDTO.class);
    }

    @Override
    public List<HabilidadDTO> getAllHabilidades() {
        List<Habilidad> habilidades = daoHabilidad.findAll();
        List<HabilidadDTO> habilidadesDTO = new ArrayList<HabilidadDTO>();
        for (Habilidad habilidad : habilidades) {
            habilidadesDTO.add(dataMapper.map(habilidad, HabilidadDTO.class));
        }
        return habilidadesDTO;
    }
    public List<HabilidadDTO> getHabilidadPorCurso(int cursoId) {
        List<HabilidadDTO> habilidadesDTO = new ArrayList<>();
        List<Curso> cursos = daoCurso.findAll();
        for (Curso curso : cursos) {
            if(curso.getId_curso() == cursoId){
                for(HabilidadesCurso habilidadesCurso : curso.getHabilidadesCurso()){
                    Habilidad habilidad = habilidadesCurso.getHabilidad();
                    habilidadesDTO.add(dataMapper.map(habilidad, HabilidadDTO.class));
                }
            }
        }
        return habilidadesDTO.isEmpty() ? null : habilidadesDTO;
    }
}
