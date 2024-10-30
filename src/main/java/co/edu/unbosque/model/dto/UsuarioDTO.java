package co.edu.unbosque.model.dto;

import java.time.LocalDate;

public class UsuarioDTO {

    private String username;
    private String userpass;
    private String tipoUsuario;
    private LocalDate fechaRegistro;
    private LocalDate ultimoAcceso;
    private String estadoUsuario;

    public UsuarioDTO() {

    }

    public UsuarioDTO(String username, String userpass, String tipoUsuario, LocalDate fechaRegistro, LocalDate ultimoAcceso, String estadoUsuario) {
        this.username = username;
        this.userpass = userpass;
        this.tipoUsuario = tipoUsuario;
        this.fechaRegistro = fechaRegistro;
        this.ultimoAcceso = ultimoAcceso;
        this.estadoUsuario = estadoUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(LocalDate ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
}
