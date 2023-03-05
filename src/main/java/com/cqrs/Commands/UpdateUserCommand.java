package main.java.com.cqrs.Commands;

import main.java.com.cqrs.Models.Write.Address;
import main.java.com.cqrs.Models.Write.Contact;

import java.util.Set;

public class UpdateUserCommand {
    private String userId;
    private Set<Address> addresses;
    private Set<Contact> contacts;

    public UpdateUserCommand(String userId, Set<Contact> contacts, Set<Address> addresses) {
        this.userId = userId;
        this.contacts = contacts;
        this.addresses = addresses;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
}
