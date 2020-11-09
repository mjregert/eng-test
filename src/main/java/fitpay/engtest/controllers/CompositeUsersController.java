package fitpay.engtest.controllers;

import fitpay.engtest.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CompositeUsersController extends BaseController {
    private final CreditCardsController creditCardsController = new CreditCardsController();
    private final DevicesController devicesController = new DevicesController();
    private final UsersController usersController = new UsersController();

    @GetMapping("/compositeUsers")
    @ResponseBody
    public List<CompositeUser> getUsers() throws IOException, InterruptedException {
        List<CompositeUser> response = new ArrayList<>();

        // Use the UsersController to get a list of users
        List<User> users = usersController.getUsers();
        // Create a new CompositeUser for each user by using transform
        for (User user : users) {
            response.add(transform(user));
        }
        return response;
    }

    @GetMapping("/compositeUsers/{id}")
    @ResponseBody
    public CompositeUser getUser(@PathVariable String id,
                                 @RequestParam(required = false) String creditCardState,
                                 @RequestParam(required = false) String deviceState)
                                 throws IOException, InterruptedException {
        // Use the UsersController to get the user and transform it to a CompositeUser
        return transform(usersController.getUser(id), creditCardState, deviceState);
    }

    private CompositeUser transform(User user) throws IOException, InterruptedException {
        return transform(user, null, null);
    }

    private CompositeUser transform(User user, String creditCardState, String deviceState) throws IOException, InterruptedException {
        CompositeUser compositeUser = new CompositeUser(user.getUserId());

        // Use the DeviceController to get a list of the devices
        List<Device> devices = devicesController.getDevices(compositeUser.getUserId());
        // Create a new CompositeDevice for each device and add it to the composite user
        for (Device device : devices) {
            if (null == deviceState || deviceState.equals(device.getState())) {
                CompositeDevice compositeDevice = new CompositeDevice(device.getDeviceIdentifier(), device.getState());
                compositeUser.getDevices().add(compositeDevice);
            }
        }

        // Use the CreditCardController to get a list of the credit cards
        List<CreditCard> creditCards = creditCardsController.getCreditCards(compositeUser.getUserId());
        // Create a new CompositeCreditCard for each credit card and add it to the composite user
        for (CreditCard creditCard : creditCards) {
            if (null == creditCardState || creditCardState.equals(creditCard.getState())) {
                CompositeCreditCard compositeCreditCard = new CompositeCreditCard(creditCard.getCreditCardId(), creditCard.getState());
                compositeUser.getCreditCards().add(compositeCreditCard);
            }
        }

        return compositeUser;
    }
}
