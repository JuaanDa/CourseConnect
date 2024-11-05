package co.edu.unbosque.model.dto;

public class HabilidadDTO {

    private int idHabilidad;
    private String nombreHabilidad;
    private String descripcion;

    public HabilidadDTO() {

    }

    public HabilidadDTO(int idHabilidad, String nombreHabilidad, String descripcion) {

        this.idHabilidad = idHabilidad;
        this.nombreHabilidad = nombreHabilidad;
        this.descripcion = descripcion;
    }

    public int getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(int idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
