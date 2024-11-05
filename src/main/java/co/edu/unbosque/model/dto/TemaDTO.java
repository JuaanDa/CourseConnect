package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.entities.Usuario;

import java.time.LocalDate;

public class TemaDTO {

    private int idTema;
    private LocalDate fechaCreacion;
    private Usuario creadoPor;
    private String nombreTema;
    private String descripcionTema;

    public TemaDTO() {

    }

    public TemaDTO(int idTema, LocalDate fechaCreacion, Usuario creadoPor, String nombreTema, String descripcionTema) {
        this.idTema = idTema;
        this.fechaCreacion = fechaCreacion;
        this.creadoPor = creadoPor;
        this.nombreTema = nombreTema;
        this.descripcionTema = descripcionTema;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Usuario creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public String getDescripcionTema() {
        return descripcionTema;
    }

    public void setDescripcionTema(String descripcionTema) {
        this.descripcionTema = descripcionTema;
    }
}
