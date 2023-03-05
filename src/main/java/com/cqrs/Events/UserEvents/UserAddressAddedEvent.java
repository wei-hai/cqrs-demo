package main.java.com.cqrs.Events.UserEvents;

import main.java.com.cqrs.Events.Event;

public class UserAddressAddedEvent extends Event {
    private String userId;
    private String city;
    private String state;
    private String postCode;

    public UserAddressAddedEvent(String userId, String city, String state, String postCode) {
        this.userId = userId;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
