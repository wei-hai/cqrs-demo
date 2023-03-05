package main.java.com.cqrs.Models.Read;

import main.java.com.cqrs.Models.Write.Contact;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserContact {
    private Map<String, Set<Contact>> contactByType = new HashMap<>();

    public Map<String, Set<Contact>> getContactByType() {
        return contactByType;
    }

    public void setContactByType(Map<String, Set<Contact>> contactByType) {
        this.contactByType = contactByType;
    }
}
