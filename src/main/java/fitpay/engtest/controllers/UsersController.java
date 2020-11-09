package fitpay.engtest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fitpay.engtest.models.User;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
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
        HttpResponse<String> response = sendGet(url);
        return getUsers(response);
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public User getUser(@PathVariable String id) throws IOException, InterruptedException {
        String url = String.format("%s/%s/%s", BASEURL, "users", id);
        HttpResponse<String> response = sendGet(url);
        return getUser(response);
    }

    private List<User> getUsers(HttpResponse<String> response) throws IOException {
        JSONObject responseJson = new JSONObject(response.body());
        List<User> users = new ArrayList<>();
        if (responseJson.has("results")) {
            JSONArray array = responseJson.getJSONArray("results");
            for (Object user : array) {
                users.add(getUser((JSONObject) user));
            }
        }
        return users;
    }
    private User getUser(HttpResponse<String> response) throws IOException {
        return getUser(new JSONObject(response.body()));
    }

    private User getUser(JSONObject json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json.toString(), User.class);
    }
}
