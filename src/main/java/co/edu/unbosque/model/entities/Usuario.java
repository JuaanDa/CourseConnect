package co.edu.unbosque.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "USUARIOS")

@NamedQueries({
        @NamedQuery(name="Usuario.findAll", query = "SELECT u FROM Usuario u")
})
public class Usuario {

    @Id
    @Column(name = "username", nullable = false, length = 15, unique = true)
    private String username;

    @Column(name = "userpass", nullable = false, length = 255)
    private String userpass;

    @Column(name = "tipo_usuario", nullable = false, length = 15)
    private String tipoUsuario;

    @Column(name = "fecha_registro", nullable = false)
//    @Temporal(TemporalType.DATE)
    private LocalDate fechaRegistro;

    @Column(name = "ultimo_acceso")
 //   @Temporal(TemporalType.TIMESTAMP)
    private LocalDate ultimoAcceso;

    @Column(name = "estado_usuario", nullable = false, length = 15)
    private String estadoUsuario;


    public Usuario() {

    }

    public Usuario(String username, String userpass, String tipoUsuario, LocalDate fechaRegistro, LocalDate ultimoAcceso, String estadoUsuario) {
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