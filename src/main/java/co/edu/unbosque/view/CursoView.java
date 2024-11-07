package co.edu.unbosque.view;

import co.edu.unbosque.model.dto.CursoDTO;
import co.edu.unbosque.model.dto.HabilidadDTO;
import co.edu.unbosque.model.dto.TemaDTO;
import co.edu.unbosque.model.dto.UsuarioDTO;
import co.edu.unbosque.model.entities.*;
import co.edu.unbosque.services.CursoService;
import co.edu.unbosque.services.TemaService;
import co.edu.unbosque.services.UsuarioService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named("cursoView")
@RequestScoped
public class CursoView implements Serializable {
    private ArrayList<CursoDTO> cursos;
    private ArrayList<CursoDTO> cursosPorVencer;
    private ArrayList<UsuarioDTO> usuarios;
    private CursoDTO cursoDTO;
    private TemaDTO temaDTO;
    private UsuarioDTO usuarioDTO;
    private HabilidadDTO habilidadDTO;
    private TemasCursoId temasCursoId;

    private Map<String, String> cursosTipo;
    private Map<String, String> cursosModalidad;
    private Map<String, String> cursoEstado;
    private boolean filtroAplicado;


    @Inject
    private CursoService cursoService;
    @Inject
    private UsuarioService usuarioService;
    @Inject
    private PaginationView paginationView;
    @Named
    @Inject
    private TemaService temaService;

    @PostConstruct
    public void init() {
        cursosTipo = new HashMap<>();
        cursosTipo.put("Educación Continua", "EduContinua");
        cursosTipo.put("Micro Credenciales", "Microcredencial");
        cursosTipo.put("Macro Credenciales", "Macrocredencial");

        cursosModalidad = new HashMap<>();
        cursosModalidad.put("Presencial", "presencial");
        cursosModalidad.put("Híbrido", "hibirido");
        cursosModalidad.put("Online en vivo", "online_vivo");
        cursosModalidad.put("Virtual", "virtual");

        cursoEstado = new HashMap<>();
        cursoEstado.put("ACTIVO", "ACTIVO");
        cursoEstado.put("FINALIZADO", "FINALIZADO");


        cursos = (ArrayList<CursoDTO>) cursoService.getAllCursos();
        cursosPorVencer = (ArrayList<CursoDTO>) cursoService.getCursoPorVencer();
        usuarios = (ArrayList<UsuarioDTO>) cursoService.getAllUsuarios();
        filtroAplicado = false;

    }

    public CursoView() {
        filtroAplicado = false;
        cursoDTO = new CursoDTO();
        temaDTO = new TemaDTO();
        habilidadDTO = new HabilidadDTO();
        usuarioDTO = new UsuarioDTO();
        temasCursoId = new TemasCursoId();


    }

    public ArrayList<CursoDTO> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<CursoDTO> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<CursoDTO> getCursosPorVencer() {
        return cursosPorVencer;
    }

    public void setCursosPorVencer(ArrayList<CursoDTO> cursosPorVencer) {
        this.cursosPorVencer = cursosPorVencer;
    }

    public Map<String, String> getCursosTipo() {
        return cursosTipo;
    }

    public void setCursosTipo(Map<String, String> cursosTipo) {
        this.cursosTipo = cursosTipo;
    }

    public Map<String, String> getCursosModalidad() {
        return cursosModalidad;
    }

    public Map<String, String> getCursoEstado() {
        return cursoEstado;
    }

    public void setCursoEstado(Map<String, String> cursoEstado) {
        this.cursoEstado = cursoEstado;
    }

    public TemasCursoId getTemasCursoId() {
        return temasCursoId;
    }

    public void setTemasCursoId(TemasCursoId temasCursoId) {
        this.temasCursoId = temasCursoId;
    }

    public void setCursosModalidad(Map<String, String> cursosModalidad) {
        this.cursosModalidad = cursosModalidad;
    }

    public CursoDTO getCursoDTO() {
        return cursoDTO;
    }

    public void setCursoDTO(CursoDTO cursoDTO) {
        this.cursoDTO = cursoDTO;
    }

    public TemaDTO getTemaDTO() {
        return temaDTO;
    }

    public void setTemaDTO(TemaDTO temaDTO) {
        this.temaDTO = temaDTO;
    }

    public HabilidadDTO getHabilidadDTO() {
        return habilidadDTO;
    }

    public void setHabilidadDTO(HabilidadDTO habilidadDTO) {
        this.habilidadDTO = habilidadDTO;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }


    public String filtrar() {
        List<CursoDTO> filteredCursos = (ArrayList<CursoDTO>) cursoService.getCursos(cursoDTO.getTipoCurso(), cursoDTO.getTituloCurso(),cursoDTO.getTituloCurso(), cursoDTO.getFechaInicio(), cursoDTO.getModalidadCurso());
        filtroAplicado = true;
        paginationView.setCursos(filteredCursos);

        return null;
    }

    public Usuario convertUsuario(UsuarioDTO usuarioDTO) {
        return usuarioService.saveUsuario(usuarioDTO);


    }

    public String crearCurso() {

        UsuarioDTO usuarioDTO = usuarios.get(0);
        Usuario creadoPor = usuarioService.saveUsuario(usuarioDTO);
        cursoDTO.setCreadoPor(creadoPor);
        cursoService.saveCurse(cursoDTO);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Curso Creado Correctamemte"));
        return null;
    }

    public String actualizarCurso(int CursoId) {
        UsuarioDTO usuarioDTO = usuarios.get(1);
        Usuario creadoPor = usuarioService.updateUsuario(usuarioDTO);
        cursoDTO.setCreadoPor(creadoPor);
        cursoDTO.setId_Curso(CursoId);
        cursoService.updateCurso(cursoDTO);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Modificacion Realizada  Correctamemte"));

        return null;
    }
    public String actualizarCursoPrecio(int CursoId, double CostoCurso){
        CursoDTO curso = cursoService.getCurso(CursoId);
        curso.setCostoCurso(CostoCurso);
        curso.setId_Curso(CursoId);
     //   TemaDTO tema = (temaService.getTemaPorCurso(CursoId));
       //TemasCursoId temasCursoId = new TemasCursoId(tema.getIdTema(), CursoId);
        cursoService.updateCurso(curso);
        return null;
    }
    public String actualizarCursoModalidad(int CursoId, String CursoModalidad){
        CursoDTO curso = cursoService.getCurso(CursoId);
        cursoDTO.setId_Curso(CursoId);
        curso.setModalidadCurso(CursoModalidad);
        cursoService.updateCurso(curso);
        return null;
    }
    public String finalizarCursoEstado(int CursoId, String CursoEstado){

        CursoDTO curso = cursoService.getCurso(CursoId);
        cursoDTO.setId_Curso(CursoId);
        curso.setEstadoCurso(CursoEstado);


      //  cursoService.updateCurso(curso);
        return null;
    }






}
