package fitpay.engtest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fitpay.engtest.Application;
import fitpay.engtest.models.User;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

@Controller
public class UsersController extends BaseController {
    @GetMapping("/users")
    @ResponseBody
    public List<User> getUsers() throws IOException, InterruptedException {
        String url = String.format("%s/%s", BASEURL, "users");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + Application.bearerToken)
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return getUsers(getResults(response));
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public User getUser(@PathVariable String id) throws IOException, InterruptedException {
        String url = String.format("%s/%s/%s", BASEURL, "users", id);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + Application.bearerToken)
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return getUser(getResult(response));
    }

    private JSONArray getResults(HttpResponse<String> response) {
        // Convert the response to an array of objects
        JSONObject responseJson = new JSONObject(response.body());
        return responseJson.getJSONArray("results");
    }

    private JSONObject getResult(HttpResponse<String> response) {
        // Convert the response to an array of objects
        return new JSONObject(response.body());
    }

    private List<User> getUsers(JSONArray array) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> users = new ArrayList<>();

        for (Object user: array) {
            users.add(getUser((JSONObject)user));
        }
        return users;
    }

    private User getUser(JSONObject json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json.toString(), User.class);
    }
}
