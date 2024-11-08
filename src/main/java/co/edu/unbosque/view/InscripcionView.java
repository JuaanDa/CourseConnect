package co.edu.unbosque.view;

import co.edu.unbosque.api.ClientEmail;
import co.edu.unbosque.model.dto.InscripcionDTO;
import co.edu.unbosque.model.entities.InscripcionId;
import co.edu.unbosque.services.CursoService;
import co.edu.unbosque.services.InscripcionService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
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
    @Inject
    private ClientEmail clientEmail;
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
    public void correoConfirmacion(){
        try {
            // Obtener los datos del formulario
            String correoEstudiante = "nacional0831@gmail.com";  // Lo ideal sería obtener esto de tu formulario JSF
            int idCurso = 5;  // Igualmente, se obtiene del formulario

            // Llamar al método que envía el link de inscripción
            clientEmail.enviarLinkInscripcion(correoEstudiante, idCurso);

            // Mostrar un mensaje de éxito (por ejemplo, con PrimeFaces o FacesContext)
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El link de inscripción fue enviado correctamente."));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al enviar el correo", e.getMessage()));
        }
    }
    }



