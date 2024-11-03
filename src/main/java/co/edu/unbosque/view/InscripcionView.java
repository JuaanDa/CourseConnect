package co.edu.unbosque.view;

import co.edu.unbosque.model.dto.InscripcionDTO;
import co.edu.unbosque.services.InscripcionService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("inscripcionView")
@RequestScoped
public class InscripcionView implements Serializable {
    private InscripcionDTO inscripcionDTO;
    @Inject
    private InscripcionService inscripcionService;
    public InscripcionView() {
        inscripcionDTO = new InscripcionDTO();
    }

    public InscripcionDTO getInscripcionDTO() {
        return inscripcionDTO;
    }

    public void setInscripcionDTO(InscripcionDTO inscripcionDTO) {
        this.inscripcionDTO = inscripcionDTO;
    }
    public String crearInscripción(){

        System.out.println("creando");
        inscripcionService.saveInscripcion(inscripcionDTO);
        return null;
    }
}

