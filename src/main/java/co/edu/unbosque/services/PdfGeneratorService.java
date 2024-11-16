package co.edu.unbosque.services;


import co.edu.unbosque.model.dto.CursoDTO;
import co.edu.unbosque.model.dto.EstudianteDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
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
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();

            // Agregar contenido al PDF
            document.add(new Paragraph("Información del Curso"));
            document.add(new Paragraph("Curso: " + cursoDTO.getTituloCurso()));
            document.add(new Paragraph("Nombre del Usuario: " + estudianteDTO.getNombre() + " " + estudianteDTO.getApellidos()));
            document.add(new Paragraph("Cédula del Usuario: " + estudianteDTO.getIdEstudiante()));
        } catch (DocumentException | IOException e) {
            throw new RuntimeException("Error al generar el PDF", e);

      //      e.printStackTrace();
        } finally {
            document.close();
        }
}}
