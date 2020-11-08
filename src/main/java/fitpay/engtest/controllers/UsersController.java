package fitpay.engtest.controllers;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import fitpay.engtest.Application;
import fitpay.engtest.models.Users;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

@Controller
public class UsersController extends BaseController {
    @GetMapping("/users")
    @ResponseBody
    public String getUsers() throws IOException, InterruptedException {
        String url = String.format("%s/%s", BASEURL, "users"); //"users/137693a0-b4ab-4345-8132-a475930d1a63");
//        System.out.println("Command = " + command);
//        BufferedReader reader;
//
//        URL url = new URL(command);
//        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
//        connection.setRequestProperty("Authorization", "Bearer " + Application.oAuthToken);
//        connection.setDoOutput(true);
//        connection.setRequestMethod("GET");
//        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//
//
//        String line;
//        StringBuilder stringBuilder = new StringBuilder();
//        while ((line = reader.readLine()) != null) {
//            stringBuilder.append(line);
//        }
//
//        ObjectMapper mapper = new ObjectMapper();
//
        //---------------------------------------
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().header("Authorization", "Bearer " + Application.bearerToken).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());
        JSONArray jArray = json.getJSONArray("results");
        return null;
    }
}
