package co.edu.unbosque.services;


import co.edu.unbosque.model.dto.CursoDTO;
import co.edu.unbosque.model.dto.EstudianteDTO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.modelmapper.ModelMapper;

import java.io.FileOutputStream;
import java.io.IOException;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;


@Named
@RequestScoped
public class PdfGeneratorService implements PdfGeneratorInterface {

    private final ModelMapper dataMapper;


    public PdfGeneratorService() {
        dataMapper = new ModelMapper();
        dataMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(PRIVATE);
    }


    @Override
    public void createPDF(String filename, CursoDTO cursoDTO, EstudianteDTO estudianteDTO) {


        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Juan/Desktop/"+filename+".pdf"));
            document.open();

            document.add(new Paragraph("Certificado Aprobación del curso"));
            document.add(new Paragraph("Curso: " + cursoDTO.getTituloCurso()));
            document.add(new Paragraph("Nombre del Usuario: " + estudianteDTO.getNombre() + " " + estudianteDTO.getApellidos()));
            document.add(new Paragraph("Cédula del Usuario: " + estudianteDTO.getIdEstudiante()));
            document.add(new Paragraph("Felicitaciones " + estudianteDTO.getNombre() + " " + estudianteDTO.getApellidos() + ", por haber participado en el curso: " + cursoDTO.getTituloCurso()+"Cursado Desde "+cursoDTO.getFechaInicio()+" hasta "+cursoDTO.getFechaFin()));
            Font cursiva = FontFactory.getFont("Brush Script MT", 18, Font.ITALIC); // Fuente manuscrita
            document.add(new Paragraph("__________________________________"));
            document.add(new Paragraph("Juan Pareja Laura Torres Juan Angel", cursiva));
            document.add(new Paragraph("CurseConnect", cursiva));
            document.add(new Paragraph("__________________________________", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.ITALIC)));
        } catch (DocumentException | IOException e) {
            throw new RuntimeException("Error al generar el PDF", e);

      //      e.printStackTrace();
        } finally {
            document.close();
        }
}}
