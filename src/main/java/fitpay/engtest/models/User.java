package fitpay.engtest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String createdTs;
    private String createdTsEpoch;
    private String id;
    private String lastModifiedTs;
    private String lastModifiedTsEpoch;
    private String userId;

    public String getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(String createdTs) {
        this.createdTs = createdTs;
    }

    public String getCreatedTsEpoch() {
        return createdTsEpoch;
    }

    public void setCreatedTsEpoch(String createdTsEpoch) {
        this.createdTsEpoch = createdTsEpoch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastModifiedTs() {
        return lastModifiedTs;
    }

    public void setLastModifiedTs(String lastModifiedTs) {
        this.lastModifiedTs = lastModifiedTs;
    }

    public String getLastModifiedTsEpoch() {
        return lastModifiedTsEpoch;
    }

    public void setLastModifiedTsEpoch(String lastModifiedTsEpoch) {
        this.lastModifiedTsEpoch = lastModifiedTsEpoch;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
