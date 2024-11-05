package co.edu.unbosque.model.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TEMAS")
@NamedQueries({
        @NamedQuery(name="Tema.findAll", query = "SELECT t FROM Tema t")
})
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tema", nullable = false)
    private int idTema;

    @Column(name = "fecha_creacion", nullable = false)
   // @Temporal(TemporalType.DATE)
    private LocalDate fechaCreacion;
    @ManyToOne
    @JoinColumn(name = "creado_por", nullable = false, referencedColumnName = "username")
    private Usuario creadoPor;

    @Column(name = "nombre_tema", nullable = false, length = 25)
    private String nombreTema;

    @Column(name = "descripcion_tema", length = 255)
    private String descripcionTema;


    public Tema() {

    }

    public Tema(int idTema, LocalDate fechaCreacion, Usuario creadoPor, String nombreTema, String descripcionTema) {
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
