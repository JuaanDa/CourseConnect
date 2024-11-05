package co.edu.unbosque.model.dto;

public class ProfesorDTO {

    private String idDocente;
    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private String resumenExperiencia;
    private String username;

    public ProfesorDTO() {

    }

    public ProfesorDTO(String idDocente, String nombre, String apellidos, String correoElectronico, String resumenExperiencia, String username) {
        this.idDocente = idDocente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.resumenExperiencia = resumenExperiencia;
        this.username = username;
    }

    public String getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(String idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getResumenExperiencia() {
        return resumenExperiencia;
    }

    public void setResumenExperiencia(String resumenExperiencia) {
        this.resumenExperiencia = resumenExperiencia;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
