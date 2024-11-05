package co.edu.unbosque.model.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "HABILIDADES")
@NamedQueries({
        @NamedQuery(name="Habilidad.findAll", query = "SELECT h FROM Habilidad h")
})

public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habilidad", nullable = false)
    private int idHabilidad;

    @Column(name = "nombre_habilidad", nullable = false, length = 35)
    private String nombreHabilidad;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @OneToMany(mappedBy = "habilidad")
    private List<HabilidadesCurso> habilidadesCursos;

    public Habilidad() {

    }

    public Habilidad(int idHabilidad, String nombreHabilidad, String descripcion) {
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

    public List<HabilidadesCurso> getHabilidadesCursos() {
        return habilidadesCursos;
    }

    public void setHabilidadesCursos(List<HabilidadesCurso> habilidadesCursos) {
        this.habilidadesCursos = habilidadesCursos;
    }
}
