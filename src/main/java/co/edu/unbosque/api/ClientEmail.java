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


    public String  enviarLinkInscripcion(String emailEstudiante, int idCurso) throws Exception {
        // Llamar al endpoint de la API que solo envía el link de inscripción
        URL url = new URL("http://localhost:8081/api/enviar-link");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setDoOutput(true);

        String data = String.format("emailEstudiante=%s&idCurso=%d", emailEstudiante, idCurso);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = data.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Verificar el código de respuesta
        int responseCode = connection.getResponseCode();
        String jsonResponse;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            jsonResponse = new String(connection.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } else {
            throw new RuntimeException("Error al enviar el link de inscripción: " + responseCode);
        }
        return jsonResponse;
    }

    public String confirmarInscripcion(String urlLinkConfirmacion) throws Exception {
        // Llamar al endpoint de confirmación
        URL url = new URL("http://localhost:8081/api/confirmar/" + urlLinkConfirmacion);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Verificar el código de respuesta
        int responseCode = connection.getResponseCode();
        String jsonResponse;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            jsonResponse = new String(connection.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            // Procesar la respuesta (puedes mapearla a un objeto DTO si es necesario)
            System.out.println("Inscripción confirmada: " + jsonResponse);
        } else {
            throw new RuntimeException("Error al confirmar la inscripción: " + responseCode);
        }
        return jsonResponse;
    }


}
