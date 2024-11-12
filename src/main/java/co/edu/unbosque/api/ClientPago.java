package co.edu.unbosque.api;

import jakarta.enterprise.context.RequestScoped;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RequestScoped
public class ClientPago {

    public String realizarPago(Map<String, String> parametros) throws IOException {
        URL url = new URL("http://localhost:8082/api/procesarPago"); // URL de la API de pagos de Spring Boot
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setDoOutput(true);

        // Construir la cadena de parámetros URL-encoded
        StringBuilder postData = new StringBuilder();
        Set<Map.Entry<String, String>> entrySet = parametros.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            if (postData.length() != 0) {
                postData.append('&');
            }
            postData.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            postData.append('=');
            postData.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }

        // Enviar los datos del formulario
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = postData.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        String jsonResponse;

        if (responseCode == HttpURLConnection.HTTP_OK) {
            jsonResponse = new String(connection.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

            return "Pago realizado exitosamente" +jsonResponse;
        } else {
            return "Error al realizar el pago, código de respuesta: " + responseCode;
        }
    }
    public String confirmarPago(Map<String, String> parametros) throws IOException {

        URL url = new URL("http://localhost:8082/api/confirmarPago"); // URL de la API de confirmación de pago
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setDoOutput(true);

        // Construir la cadena de parámetros URL-encoded
        StringBuilder postData = new StringBuilder();
        Set<Map.Entry<String, String>> entrySet = parametros.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            if (postData.length() != 0) {
                postData.append('&');
            }
            postData.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            postData.append('=');
            postData.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }

        // Enviar los datos del formulario
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = postData.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        String jsonResponse;

        if (responseCode == HttpURLConnection.HTTP_OK) {
            jsonResponse = new String(connection.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

            return "Pago confirmado exitosamente" + jsonResponse;
        } else {
            return "Error al confirmar el pago, código de respuesta: " + responseCode;
        }
    }
}
