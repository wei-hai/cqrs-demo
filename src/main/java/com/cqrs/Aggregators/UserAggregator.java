package main.java.com.cqrs.Aggregators;

import main.java.com.cqrs.Commands.CreateUserCommand;
import main.java.com.cqrs.Commands.UpdateUserCommand;
import main.java.com.cqrs.Events.Event;
import main.java.com.cqrs.Events.UserEvents.UserContactAddedEvent;
import main.java.com.cqrs.Events.UserEvents.UserContactRemovedEvent;
import main.java.com.cqrs.Events.UserEvents.UserCreatedEvent;
import main.java.com.cqrs.Models.Write.Contact;
import main.java.com.cqrs.Models.Write.User;
import main.java.com.cqrs.Repositories.EventRepository;
import main.java.com.cqrs.Repositories.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserAggregator {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    public UserAggregator(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public List<Event> handleCreateUserCommand(CreateUserCommand command) {
        System.out.println("handleCreateUserCommand");
        UserCreatedEvent event = new UserCreatedEvent(command.getUserId(), command.getFirstName(), command.getLastName());
        eventRepository.addEvent(event);
        return Arrays.asList(event);
    }

    public List<Event> handleUpdateUserCommand(UpdateUserCommand command) {
        System.out.println("handleUpdateUserCommand");
        User user = userRepository.getUser(command.getUserId());
        List<Event> events = new ArrayList<>();
        List<Contact> contactsToRemove = user.getContacts().stream().filter(c -> !command.getContacts().contains(c)).collect(Collectors.toList());
        for (Contact contact : contactsToRemove) {
            UserContactRemovedEvent contactRemovedEvent = new UserContactRemovedEvent(user.getUserid(), contact.getType(), contact.getDetails());
            events.add(contactRemovedEvent);
            eventRepository.addEvent(contactRemovedEvent);
        }
        List<Contact> contactsToAdd = command.getContacts().stream().filter(c -> !user.getContacts().contains(c)).collect(Collectors.toList());
        for (Contact contact : contactsToAdd) {
            UserContactAddedEvent contactAddedEvent = new UserContactAddedEvent(user.getUserid(), contact.getType(), contact.getDetails());
            events.add(contactAddedEvent);
            eventRepository.addEvent(contactAddedEvent);
        }
        // similarly process addressesToRemove
        // similarly process addressesToAdd
        return events;
    }
}
