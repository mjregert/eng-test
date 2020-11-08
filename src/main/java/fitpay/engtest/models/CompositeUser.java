package fitpay.engtest.models;

public class CompositeUser {
    private String creditCardId;
    private String deviceId;
    private String state;
    private String userId;

    public CompositeUser(String state, String userId) {
        this(null, null, state, userId);
    }

    public CompositeUser(String creditCardId, String deviceId, String state, String userId) {
        this.creditCardId = creditCardId;
        this.deviceId = deviceId;
        this.state = state;
        this.userId = userId;
    }

    public String getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(String creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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
