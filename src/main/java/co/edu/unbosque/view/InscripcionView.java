package co.edu.unbosque.view;

import co.edu.unbosque.api.ClientEmail;
import co.edu.unbosque.model.dto.InscripcionDTO;
import co.edu.unbosque.model.entities.Inscripcion;
import co.edu.unbosque.model.entities.InscripcionId;
import co.edu.unbosque.services.CursoService;
import co.edu.unbosque.services.EstudianteService;
import co.edu.unbosque.services.InscripcionService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDate;
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
    @Named
    @Inject
    private EstudianteService estudianteService;
    private String urlLinkConfirmacion;
    private boolean ProcesarPago;
    public InscripcionView() {
        inscripcionDTO = new InscripcionDTO();
    }

    @PostConstruct
    public void init() {
        inscripciones = (ArrayList<InscripcionDTO>) inscripcionService.getInscripciones();
        estadoInscripcion = new HashMap<>();
        estadoInscripcion.put("PAGADA", "PAGADA");
        estadoInscripcion.put("SOLICITADA", "SOLICITADA");
        estadoInscripcion.put("CONFIRMADA", "CONFIRMADA");
        inscripcionDTO.setEstadoInscripcion("SOLICITADA");
        inscripcionDTO.setCodigoParaPago("1");
        inscripcionDTO.setUrlLinkConfirmacion("1");
        ProcesarPago = false;
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

    public String getUrlLinkConfirmacion() {
        return urlLinkConfirmacion;
    }

    public void setUrlLinkConfirmacion(String urlLinkConfirmacion) {
        this.urlLinkConfirmacion = urlLinkConfirmacion;
    }

    public boolean isProcesarPago() {
        return ProcesarPago;
    }

    public void setProcesarPago(boolean procesarPago) {
        ProcesarPago = procesarPago;
    }

    public String crearInscripción() throws Exception {

        int idCurso = inscripcionDTO.getIdCurso();
        String correoEstudiante = estudianteService.getAllStudents().get(0).getCorreoElectronico();
        String url = clientEmail.enviarLinkInscripcion(correoEstudiante, idCurso);
        inscripcionDTO.setUrlLinkConfirmacion(url);

        System.out.println("creando");

        try {
            // Intentamos guardar la inscripción
            inscripcionService.saveInscripcion(inscripcionDTO);
            ProcesarPago = true;
        return "ProcesarPago.xhtml";
        } catch (Exception e) {
            // En caso de cualquier error (incluyendo duplicados), registramos el error y mostramos un mensaje
            e.printStackTrace();  // Registrar el error completo para el desarrollador

            // Mostrar un mensaje genérico al usuario
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "La inscripción ya existe para este estudiante y curso."));
        }
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



