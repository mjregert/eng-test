package fitpay.engtest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fitpay.engtest.models.Device;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DevicesController extends BaseController {
    @GetMapping("/users/{id}/devices")
    @ResponseBody
    public List<Device> getDevices(@PathVariable String id) throws IOException, InterruptedException {
        String url = String.format("%s/%s/%s/%s", BASEURL, "users", id, "devices");
        HttpResponse<String> response = sendGet(url);
        return getDevices(response);
    }

    private List<Device> getDevices(HttpResponse<String> response) throws IOException {
        JSONObject responseJson = new JSONObject(response.body());
        JSONArray array = responseJson.getJSONArray("results");
        List<Device> devices = new ArrayList<>();
        for (Object device: array) {
            ObjectMapper mapper = new ObjectMapper();
            devices.add(mapper.readValue(device.toString(), Device.class));
        }
        return devices;
    }
}
