package fitpay.engtest.models;

public class CompositeCreditCard {
    private String creditCardId;
    private String state;

    public CompositeCreditCard(String creditCardId, String state) {
        this.creditCardId = creditCardId;
        this.state = state;
    }

    public String getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(String creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
