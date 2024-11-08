package co.edu.unbosque.services;

import co.edu.unbosque.model.dao.DAO;
import co.edu.unbosque.model.dto.UsuarioDTO;
import co.edu.unbosque.model.entities.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Named
@RequestScoped
public class UsuarioService  implements UsuarioServiceinterface {
    @Inject
    private DAO<Usuario, String> daoUsuario;
    private final ModelMapper dataMapper;


    public UsuarioService() {
        dataMapper = new ModelMapper();
        dataMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(PRIVATE);

    }


    @Override
    public Usuario saveUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = dataMapper.map(usuarioDTO, Usuario.class);
      //  daoUsuario.save(usuario);
        dataMapper.map(usuarioDTO, Usuario.class);

        return usuario;
    }
    @Override
    public Usuario updateUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = dataMapper.map(usuarioDTO, Usuario.class);
        daoUsuario.update(usuario);
        return usuario;
        }

    @Override
    public List<UsuarioDTO> getUsuarios() {
            return List.of();
    }



}
