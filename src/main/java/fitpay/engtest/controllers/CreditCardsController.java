package fitpay.engtest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fitpay.engtest.models.CreditCard;
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
public class CreditCardsController extends BaseController {
    @GetMapping("/users/{id}/creditCards")
    @ResponseBody
    public List<CreditCard> getCreditCards(@PathVariable String id) throws IOException, InterruptedException {
        String url = String.format("%s/%s/%s/%s", BASEURL, "users", id, "creditCards");
        HttpResponse<String> response = sendGet(url);
        return getCreditCards(response);
    }

    private List<CreditCard> getCreditCards(HttpResponse<String> response) throws IOException {
        JSONObject responseJson = new JSONObject(response.body());
        JSONArray array = responseJson.getJSONArray("results");
        List<CreditCard> creditCards = new ArrayList<>();
        for (Object creditCard: array) {
            ObjectMapper mapper = new ObjectMapper();
            creditCards.add(mapper.readValue(creditCard.toString(), CreditCard.class));
        }
        return creditCards;
    }
}
