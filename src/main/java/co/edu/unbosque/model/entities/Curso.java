package co.edu.unbosque.model.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "CURSOS")
@NamedQueries({
        @NamedQuery(name="Curso.findAll", query = "SELECT c FROM Curso c"),
        @NamedQuery(name = "Curso.findByFilters", query = "SELECT c FROM Curso c JOIN c.temasCurso tc JOIN tc.tema t WHERE "
                + "(:tipo IS NULL OR c.tipoCurso = :tipo) AND "
                + "(:tema IS NULL OR t.nombreTema = :tema) AND "
                + "(:habilidad IS NULL OR c.tituloCurso = :habilidad) AND "
                + "(:fecha IS NULL OR c.fechaInicio = :fecha) AND "
                + "(:modalidad IS NULL OR c.modalidadCurso = :modalidad)")
})
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_curso;

    @Column(name = "titulo_curso", nullable = false, length = 50)
    private String tituloCurso;

    @Column(name = "url_imagen_curso", nullable = false, length = 50)
    private String urlImagenCurso;

    @Column(name = "tipo_curso", nullable = false, length = 15)
    private String tipoCurso;

    @Column(name = "modalidad_curso", nullable = false, length = 15)
    private String modalidadCurso;

    @Column(name = "horario_curso", nullable = false, length = 25)
    private String horarioCurso;

    @Column(name = "fecha_inicio", nullable = false)
  //  @Temporal(TemporalType.DATE)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
   // @Temporal(TemporalType.DATE)
    private LocalDate fechaFin;

    @Column(name = "horas_curso", nullable = false)
    private int horasCurso;

    @Column(name = "costo_curso", nullable = false)
    private double costoCurso;

    @Column(name = "estado_curso", nullable = false, length = 15)
    private String estadoCurso;

    @Column(name = "fecha_creacion", nullable = false)
   // @Temporal(TemporalType.DATE)
    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "creado_por", nullable = false, referencedColumnName = "username")
    private Usuario creadoPor; // Relación con la entidad Usuario

    @OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
    private List<TemasCurso> temasCurso;  // Relación con TemasCurso

    @OneToMany(mappedBy = "curso", fetch = FetchType.EAGER )
    private List<HabilidadesCurso> habilidadesCurso; // Relacion con habilidades

    @OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
    private List<ProfesoresCurso> profesoresCurso;


    public Curso() {
    }



    public Curso(int id_curso, String tituloCurso, String urlImagenCurso, String tipoCurso, String modalidadCurso, String horarioCurso, LocalDate fechaInicio, LocalDate fechaFin, int horasCurso, double costoCurso, String estadoCurso, LocalDate fechaCreacion, Usuario creadoPor) {
        this.id_curso = id_curso;
        this.tituloCurso = tituloCurso;
        this.urlImagenCurso = urlImagenCurso;
        this.tipoCurso = tipoCurso;
        this.modalidadCurso = modalidadCurso;
        this.horarioCurso = horarioCurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horasCurso = horasCurso;
        this.costoCurso = costoCurso;
        this.estadoCurso = estadoCurso;
        this.fechaCreacion = fechaCreacion;
        this.creadoPor = creadoPor;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getTituloCurso() {
        return tituloCurso;
    }

    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }

    public String getUrlImagenCurso() {
        return urlImagenCurso;
    }

    public void setUrlImagenCurso(String urlImagenCurso) {
        this.urlImagenCurso = urlImagenCurso;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getModalidadCurso() {
        return modalidadCurso;
    }

    public void setModalidadCurso(String modalidadCurso) {
        this.modalidadCurso = modalidadCurso;
    }

    public String getHorarioCurso() {
        return horarioCurso;
    }

    public void setHorarioCurso(String horarioCurso) {
        this.horarioCurso = horarioCurso;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getHorasCurso() {
        return horasCurso;
    }

    public void setHorasCurso(int horasCurso) {
        this.horasCurso = horasCurso;
    }

    public double getCostoCurso() {
        return costoCurso;
    }

    public void setCostoCurso(double costoCurso) {
        this.costoCurso = costoCurso;
    }

    public String getEstadoCurso() {
        return estadoCurso;
    }

    public void setEstadoCurso(String estadoCurso) {
        this.estadoCurso = estadoCurso;
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

    public List<TemasCurso> getTemasCurso() {
        return temasCurso;
    }

    public void setTemasCurso(List<TemasCurso> temasCurso) {
        this.temasCurso = temasCurso;
    }

    public List<HabilidadesCurso> getHabilidadesCurso() {
        return habilidadesCurso;
    }

    public void setHabilidadesCurso(List<HabilidadesCurso> habilidadesCurso) {
        this.habilidadesCurso = habilidadesCurso;
    }

    public List<ProfesoresCurso> getProfesoresCurso() {
        return profesoresCurso;
    }

    public void setProfesoresCurso(List<ProfesoresCurso> profesoresCurso) {
        this.profesoresCurso = profesoresCurso;
    }
}