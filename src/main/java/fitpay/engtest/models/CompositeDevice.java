package fitpay.engtest.models;

public class CompositeDevice {
    private String deviceId;
    private String state;

    public CompositeDevice(String deviceId, String state) {
        this.deviceId = deviceId;
        this.state = state;
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
}
