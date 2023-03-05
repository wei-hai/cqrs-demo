package main.java.com.cqrs.Events.UserEvents;

import main.java.com.cqrs.Events.Event;

public class UserContactAddedEvent extends Event {
    private String userId;
    private String contactType;
    private String contactDetails;

    public UserContactAddedEvent(String userId, String contactType, String contactDetails) {
        this.userId = userId;
        this.contactType = contactType;
        this.contactDetails = contactDetails;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
}
