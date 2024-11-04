package co.edu.unbosque.api;

import jakarta.enterprise.context.RequestScoped;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@RequestScoped
public class ClientPago {

    public String realizarPago(String jsonInput) throws IOException {
        URL url = new URL("http://localhost:8082/api/pagos"); // URL de la API de pagos de Spring Boot
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInput.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return "Pago realizado exitosamente";
        } else {
            return "Error al realizar el pago, código de respuesta: " + responseCode;
        }
    }
}
