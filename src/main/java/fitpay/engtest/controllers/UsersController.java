package fitpay.engtest.controllers;

import fitpay.engtest.Application;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

@Controller
public class UsersController extends BaseController {
    @GetMapping("/users")
    @ResponseBody
    public String getUsers() {
        String command = String.format("%s/%s", BASEURL, "users?limit=1");
        System.out.println("Command = " + command);
        BufferedReader reader;
        try {
            URL url = new URL(command);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", "Bearer " + Application.oAuthToken);
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringWriter out = new StringWriter(connection.getContentLength() > 0 ? connection.getContentLength() : 2048);
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
            return out.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
