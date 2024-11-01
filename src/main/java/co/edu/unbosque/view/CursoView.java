package co.edu.unbosque.view;

import co.edu.unbosque.model.dto.CursoDTO;
import co.edu.unbosque.model.dto.HabilidadDTO;
import co.edu.unbosque.model.dto.TemaDTO;
import co.edu.unbosque.model.dto.UsuarioDTO;
import co.edu.unbosque.model.entities.Usuario;
import co.edu.unbosque.services.CursoService;
import co.edu.unbosque.services.UsuarioService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
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
    private ArrayList<UsuarioDTO> usuarios;
    private CursoDTO cursoDTO;
    private TemaDTO temaDTO;
    private UsuarioDTO usuarioDTO;
    private HabilidadDTO habilidadDTO;
    private Map<String, String> cursosTipo = new HashMap<>();
    private Map<String, String> cursosModalidad = new HashMap<>();
    private boolean filtroAplicado;


    @Inject
    private CursoService cursoService;
    @Inject
    private UsuarioService usuarioService;
    @Inject
    private PaginationView paginationView;
    @PostConstruct
    public void init() {
        cursosTipo = new HashMap<>();
        cursosTipo.put("Educación Continua","EduContinua");
        cursosTipo.put("Micro Credenciales","Microcredencial");
        cursosTipo.put("Macro Credenciales","Macrocredencial");

        cursosModalidad = new HashMap<>();
        cursosModalidad.put("Presencial","presencial");
        cursosModalidad.put("Híbrido", "presencial, online_vivo");
        cursosModalidad.put("Online en vivo","online_vivo");
        cursosModalidad.put("Virtual","virtual");

        cursos  = (ArrayList<CursoDTO>) cursoService.getAllCursos();
        usuarios = (ArrayList<UsuarioDTO>) cursoService.getAllUsuarios();
        filtroAplicado = false;

    }

    public CursoView(){
        filtroAplicado = false;
        cursoDTO = new CursoDTO();
        temaDTO = new TemaDTO();
        habilidadDTO = new HabilidadDTO();
        usuarioDTO = new UsuarioDTO();


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


    public String filtrar(){
        System.out.println("filtrando");
        List<CursoDTO> filteredCursos = (ArrayList<CursoDTO>) cursoService.getCursosByTipo(cursoDTO.getTipoCurso());
        filtroAplicado = true;
        // Actualiza la lista de cursos en PaginationView
        paginationView.setCursos(filteredCursos);

        return null;
    }
    public Usuario convertUsuario(UsuarioDTO usuarioDTO) {
        return usuarioService.saveUsuario(usuarioDTO);


    }
    public void quitarFiltro() {
        System.out.println("Quitando filtro");
        cursos = (ArrayList<CursoDTO>) cursoService.getAllCursos();
        filtroAplicado = false; // Restablece el estado del filtro
    }

    public String crearCurso() {
        UsuarioDTO usuarioDTO = usuarios.get(0);
        Usuario creadoPor = usuarioService.saveUsuario(usuarioDTO);
        cursoDTO.setCreadoPor(creadoPor);
        cursoService.saveCurse(cursoDTO);
        return null;
    }





}
