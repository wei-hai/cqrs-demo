package main.java.com.cqrs.Queries;

public class UserAddressByRegionQuery {
    private String userId;
    private String state;

    public UserAddressByRegionQuery(String userId, String state) {
        this.userId = userId;
        this.state = state;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
