package fitpay.engtest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCard {
    private String cardType;
    private String creditCardId;
    private String state;
    private String userId;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
