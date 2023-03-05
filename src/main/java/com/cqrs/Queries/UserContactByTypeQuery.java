package main.java.com.cqrs.Queries;

public class UserContactByTypeQuery {
    private String userId;
    private String contactType;

    public UserContactByTypeQuery(String userId, String contactType) {
        this.userId = userId;
        this.contactType = contactType;
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
}
