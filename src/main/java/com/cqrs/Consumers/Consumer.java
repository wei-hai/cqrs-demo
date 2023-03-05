package main.java.com.cqrs.Consumers;

import main.java.com.cqrs.Events.Event;
import main.java.com.cqrs.Events.UserEvents.*;
import main.java.com.cqrs.Models.Read.UserAddress;
import main.java.com.cqrs.Models.Write.Address;
import main.java.com.cqrs.Repositories.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Consumer {
    private UserRepository userRepository;

    public Consumer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void dispatch(Event event) {
        if (event instanceof UserCreatedEvent) {
            process((UserCreatedEvent) event);
        }
        if (event instanceof UserAddressAddedEvent) {
            process((UserAddressAddedEvent) event);
        }
        if (event instanceof UserAddressRemovedEvent) {
            process((UserAddressRemovedEvent) event);
        }
        if (event instanceof UserContactAddedEvent) {
            process((UserContactAddedEvent) event);
        }
        if (event instanceof UserContactRemovedEvent) {
            process((UserContactRemovedEvent) event);
        }
    }

    private void process(UserCreatedEvent event) {
        System.out.println("UserCreatedEvent");
    }

    private void process(UserAddressAddedEvent event) {
        System.out.println("UserAddressAddedEvent");
        Address address = new Address(event.getCity(), event.getState(), event.getPostCode());
        UserAddress userAddress = Optional.ofNullable(
                        userRepository.getUserAddress(event.getUserId()))
                .orElse(new UserAddress());
        Set<Address> addresses = Optional.ofNullable(userAddress.getAddressByRegion()
                        .get(address.getState()))
                .orElse(new HashSet<>());
        addresses.add(address);
        userAddress.getAddressByRegion()
                .put(address.getState(), addresses);
        userRepository.setUserAddress(event.getUserId(), userAddress);
    }

    private void process(UserAddressRemovedEvent event) {
        System.out.println("UserAddressRemovedEvent");
        Address address = new Address(
                event.getCity(), event.getState(), event.getPostCode());
        UserAddress userAddress = userRepository.getUserAddress(event.getUserId());
        if (userAddress != null) {
            Set<Address> addresses = userAddress.getAddressByRegion()
                    .get(address.getState());
            if (addresses != null)
                addresses.remove(address);
            userRepository.setUserAddress(event.getUserId(), userAddress);
        }
    }

    private void process(UserContactAddedEvent event) {
        System.out.println("UserContactAddedEvent");
    }

    private void process(UserContactRemovedEvent event) {
        System.out.println("UserContactRemovedEvent");
    }
}
