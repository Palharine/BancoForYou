package org.foryou.bancoforyou.Gemini;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Gemini {

    private static final String API_KEY = System.getenv("API_KEY");   

    public static String getCompletion(String prompt) throws Exception {

        // Montando JSON corretamente com GSON
        JsonObject textPart = new JsonObject();
        textPart.addProperty("text", prompt);

        JsonArray parts = new JsonArray();
        parts.add(textPart);

        JsonObject content = new JsonObject();
        content.add("parts", parts);

        JsonArray contentsArray = new JsonArray();
        contentsArray.add(content);

        JsonObject data = new JsonObject();
        data.add("contents", contentsArray);

        System.out.println("Payload enviado: " + data.toString());

        HttpClient client = SelfCertificatedServer.getHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + API_KEY))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException(
                    "Erro da API: " + response.statusCode() + " - " + response.body()
            );
        }

        System.out.println("Resposta do Gemini: " + response.body());

        // Decodifica JSON usando Gson
        JsonObject json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();

        String text =
                json.getAsJsonArray("candidates")
                        .get(0).getAsJsonObject()
                        .getAsJsonObject("content")
                        .getAsJsonArray("parts")
                        .get(0).getAsJsonObject()
                        .get("text").getAsString();

        return text;
    }
}

