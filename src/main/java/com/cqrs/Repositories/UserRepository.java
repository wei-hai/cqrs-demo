package main.java.com.cqrs.Repositories;

import main.java.com.cqrs.Models.Read.UserAddress;
import main.java.com.cqrs.Models.Read.UserContact;
import main.java.com.cqrs.Models.Write.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> userStore = new HashMap<>();
    private Map<String, UserAddress> userAddressStore = new HashMap<>();
    private Map<String, UserContact> userContactStore = new HashMap<>();
    public User getUser(String userId) {
        return userStore.get(userId);
    }
    public UserContact getUserContact(String userId) {
        return userContactStore.get(userId);
    }
    public UserAddress getUserAddress(String userId) {
        return userAddressStore.get(userId);
    }

    public User addUser(User user) {
        userStore.put(user.getUserid(), user);
        return user;
    }
    public void setUserContact(String userId, UserContact userContact) {
        userContactStore.put(userId, userContact);
    }

    public void setUserAddress(String userId, UserAddress userAddress) {
        userAddressStore.put(userId, userAddress);
    }
}
