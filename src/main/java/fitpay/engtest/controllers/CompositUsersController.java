package fitpay.engtest.controllers;

import fitpay.engtest.models.CompositeUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CompositUsersController {
    @GetMapping("/compositeUsers")
    @ResponseBody
    public List<CompositeUser> getUsers() {
        CompositeUser a = new CompositeUser("Colorado", "ID_1");
        CompositeUser b = new CompositeUser("Texas", "ID_2");
        List<CompositeUser> response = new ArrayList<CompositeUser>();
        response.add(a);
        response.add(b);
        return response;
    }
}
