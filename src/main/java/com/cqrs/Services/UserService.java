package main.java.com.cqrs.Services;

import main.java.com.cqrs.Models.Address;
import main.java.com.cqrs.Models.Contact;
import main.java.com.cqrs.Models.User;
import main.java.com.cqrs.Repositories.UserRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        userRepository = repository;
    }

    public void createUser(String userId, String firstName, String lastName) {
        User user = new User(userId, firstName, lastName);
        userRepository.addUser(userId, user);
    }

    public void updateUser(String userId, Set<Contact> contacts, Set<Address> addresses) {
        Optional<User> optionalUser = userRepository.getUser(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setContacts(contacts);
            user.setAddresses(addresses);
            userRepository.addUser(userId, user);
        }
    }

    public Optional<Set<Contact>> getContactByType(String userId, String contactType) {
        Optional<User> optionalUser = userRepository.getUser(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Set<Contact> contacts = user.getContacts();
            return Optional.of(contacts.stream().filter(c -> c.getType().equals(contactType)).collect(Collectors.toSet()));
        }
        return Optional.empty();
    }

    public Optional<Set<Address>> getAddressByRegion(String userId, String state) {
        Optional<User> optionalUser = userRepository.getUser(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Set<Address> address = user.getAddresses();
            return Optional.of(address.stream().filter(a -> a.getState().equals(state)).collect(Collectors.toSet()));
        }
        return Optional.empty();
    }
}
