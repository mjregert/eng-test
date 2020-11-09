package fitpay.engtest.controllers;

import fitpay.engtest.Application;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class BaseController {
    public static final String BASEURL = "https://api.qa.fitpay.ninja";

    HttpResponse<String> sendGet(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + Application.bearerToken)
                .GET()
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
