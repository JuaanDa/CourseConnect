package co.edu.unbosque.services;

import co.edu.unbosque.model.dto.UsuarioDTO;
import co.edu.unbosque.model.entities.Usuario;

import java.util.List;

public interface UsuarioServiceinterface {
    Usuario saveUsuario(UsuarioDTO usuario);
    List<UsuarioDTO> getUsuarios();
    void deleteUsuario(int id);
    void updateUsuario(UsuarioDTO usuario);
}
