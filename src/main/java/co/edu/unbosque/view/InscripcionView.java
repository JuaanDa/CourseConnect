package co.edu.unbosque.view;

import co.edu.unbosque.model.dto.InscripcionDTO;
import co.edu.unbosque.model.entities.InscripcionId;
import co.edu.unbosque.services.CursoService;
import co.edu.unbosque.services.InscripcionService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Named("inscripcionView")
@RequestScoped
public class InscripcionView implements Serializable {
    private InscripcionDTO inscripcionDTO;
    private ArrayList<InscripcionDTO> inscripciones;
    @Inject
    private InscripcionService inscripcionService;
    private Map<String, String> estadoInscripcion = new HashMap<>();
    @Inject
    private CursoService cursoService;

    public InscripcionView() {
        inscripcionDTO = new InscripcionDTO();
    }
    @PostConstruct
    public void init() {
        inscripciones = (ArrayList<InscripcionDTO>) inscripcionService.getInscripciones();
        estadoInscripcion = new HashMap<>();
        estadoInscripcion.put("Pagada", "PAGADA");
        estadoInscripcion.put("Solicitada", "SOLICITADA");
        estadoInscripcion.put("Confirmada", "CONFIRMADA");

    }

    public InscripcionDTO getInscripcionDTO() {
        return inscripcionDTO;
    }

    public ArrayList<InscripcionDTO> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<InscripcionDTO> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public void setInscripcionDTO(InscripcionDTO inscripcionDTO) {
        this.inscripcionDTO = inscripcionDTO;
    }

    public Map<String, String> getEstadoInscripcion() {
        return estadoInscripcion;
    }

    public void setEstadoInscripcion(Map<String, String> estadoInscripcion) {
        this.estadoInscripcion = estadoInscripcion;
    }

    public String crearInscripción(){
        System.out.println("creando");
        inscripcionService.saveInscripcion(inscripcionDTO);
        return null;
    }
    public String actualizarInscripcion(int CursoId, String EstId, String Estado) {
        System.out.println("actualizando");
        InscripcionId inscripcionId = new InscripcionId(CursoId, EstId);
         InscripcionDTO inscripcion = inscripcionService.getInscripcionById(inscripcionId);
         inscripcionDTO.setIdCurso(CursoId);
         inscripcion.setEstadoInscripcion(Estado);
        inscripcionService.updateInscripcion(inscripcion);
        return null;
    }

}

