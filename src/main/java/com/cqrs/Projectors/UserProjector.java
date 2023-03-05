package main.java.com.cqrs.Projectors;

import main.java.com.cqrs.Models.Read.UserAddress;
import main.java.com.cqrs.Models.Read.UserContact;
import main.java.com.cqrs.Models.Write.Address;
import main.java.com.cqrs.Models.Write.Contact;
import main.java.com.cqrs.Queries.UserAddressByRegionQuery;
import main.java.com.cqrs.Queries.UserContactByTypeQuery;
import main.java.com.cqrs.Repositories.UserRepository;

import java.util.Set;

public class UserProjector {
    private final UserRepository userRepository;

    public UserProjector(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Set<Contact> handleUserContactByTypeQuery(UserContactByTypeQuery query) {
        UserContact userContact = userRepository.getUserContact(query.getUserId());
        return userContact.getContactByType().get(query.getContactType());
    }
    public Set<Address> handleUserAddressByRegionQuery(UserAddressByRegionQuery query) {
        UserAddress userAddress = userRepository.getUserAddress(query.getUserId());
        return userAddress.getAddressByRegion().get(query.getState());
    }
}
