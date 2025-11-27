package org.foryou.bancoforyou.Gemini;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.URI;
import com.google.api.client.http.HttpRequest;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class Gemini{
	private static final String API_KEY = "API_KEY"

    public static String getCompletion(String prompt) throws Exception{
        JsonObject data = new JsonObject();
        JsonArray partsArray = new JsonArray().put(new JSONObject().put("text", prompt));
        data.put ("contents", new JSONArray().put(new JSONObject().put("parts", partsArray)));
    System.out.println("Paramêtros do envio: " + data.toString());
    HttpClient client = SelfCerticatedServer.getHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(new URI("")).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(data.toString())).build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    if (response.statusCode() != 200){
        throw new RuntimeException("Erro na requisição: " + response.statusCode() + " - " + response.body());
    } else {
        System.out.println("Resposta da API: " + response.body());
        return new JsonObject(response.body())
            .getJSONArray("candidates")
            .getJSONObject(0)
            .getJSONObject("content")
            .getJSONArray("parts")
            .getJSONObject(0)
            .getString("text");
    }


    }
}
