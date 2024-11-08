package co.edu.unbosque.api;


import co.edu.unbosque.model.dto.InscripcionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.RequestScoped;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@RequestScoped
public class ClientEmail {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // Metodo para crear una inscripción
    public InscripcionDTO crearInscripcion(int idCurso, String idEstudiante) throws Exception {
        URL url = new URL("http://localhost:8081/api/rear");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // Crear el JSON con los datos, solamente incluyo el id del curso y estudiante por que son los necesarios para
        // la creación de la inscripción
        String jsonInput = String.format("{\"idCurso\": %d, \"idEstudiante\": \"%s\"}", idCurso, idEstudiante);

        //SE ENVIAN LOS DATOS DEL JASON Y ESTABLECE LA CONEXION Y LO ENVIA COMO BYTES
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return objectMapper.readValue(connection.getInputStream(), InscripcionDTO.class);
        } else {
            throw new RuntimeException("Error al crear inscripción: " + responseCode);
        }
    }

    // Metodo para confirmar inscripción
    public InscripcionDTO confirmarInscripcion(String urlLinkConfirmacion) throws Exception {
        URL url = new URL("http://localhost:8081/api/confirm/" + urlLinkConfirmacion);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return objectMapper.readValue(connection.getInputStream(), InscripcionDTO.class);
        } else {
            throw new RuntimeException("Error al confirmar inscripción: " + responseCode);
        }
    }
    //Método para enviar solo el link de inscripción

    public String  enviarLinkInscripcion(String emailEstudiante, int idCurso) throws Exception {
        // Llamar al endpoint de la API que solo envía el link de inscripción
        URL url = new URL("http://localhost:8081/api/enviar-link");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setDoOutput(true);

        // Crear el cuerpo de la solicitud con los parámetros email y idCurso
        String data = String.format("emailEstudiante=%s&idCurso=%d", emailEstudiante, idCurso);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = data.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Verificar el código de respuesta
        int responseCode = connection.getResponseCode();
        String linkDeInscripcion;
        String jsonResponse;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            jsonResponse = new String(connection.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } else {
            throw new RuntimeException("Error al enviar el link de inscripción: " + responseCode);
        }
        return jsonResponse;
    }
}
