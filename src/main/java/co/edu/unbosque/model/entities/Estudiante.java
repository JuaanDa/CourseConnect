package co.edu.unbosque.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ESTUDIANTES")
@NamedQueries({
        @NamedQuery(name="Estudiante.findAll", query = "SELECT e FROM Estudiante e")
})
public class Estudiante {

    @Id
    @Column(name = "id_estudiante", nullable = false, length = 15)
    private String idEstudiante;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 20)
    private String apellidos;

    @Column(name = "correo_electronico", nullable = false, length = 30)
    private String correoElectronico;

    @Column(name = "celular", length = 10)
    private String celular;

    @Column(name = "username", nullable = false, length = 15)
    private String username;

    public Estudiante() {

    }

    public Estudiante(String idEstudiante, String nombre, String apellidos, String correoElectronico, String celular, String username) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.celular = celular;
        this.username = username;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}