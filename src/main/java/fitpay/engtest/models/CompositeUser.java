package fitpay.engtest.models;

import java.util.ArrayList;
import java.util.List;

public class CompositeUser {
    private String userId;
    private List<CompositeCreditCard> creditCards;
    private List<CompositeDevice> devices;

    public CompositeUser(String userId) {
        this.userId = userId;
        creditCards = new ArrayList<>();
        devices = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CompositeCreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CompositeCreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public List<CompositeDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<CompositeDevice> devices) {
        this.devices = devices;
    }
}
