package co.edu.unbosque.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PROFESORES")
public class Profesor {

    @Id
    @Column(name = "id_docente", nullable = false, length = 15)
    private String idDocente;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 20)
    private String apellidos;

    @Column(name = "correo_electronico", nullable = false, length = 30)
    private String correoElectronico;

    @Column(name = "resumen_experiencia", nullable = false, length = 255)
    private String resumenExperiencia;

    @Column(name = "username", nullable = false, length = 15)
    private String username;

    public Profesor() {

    }
    public Profesor(String idDocente, String nombre, String apellidos, String correoElectronico, String resumenExperiencia, String username) {
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
