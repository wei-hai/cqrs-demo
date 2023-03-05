package main.java.com.cqrs;

import main.java.com.cqrs.Aggregators.UserAggregator;
import main.java.com.cqrs.Consumers.Consumer;
import main.java.com.cqrs.Events.Event;
import main.java.com.cqrs.Projectors.UserProjector;
import main.java.com.cqrs.Repositories.EventRepository;
import main.java.com.cqrs.Repositories.UserRepository;
import main.java.com.cqrs.Services.UserService;

public class Main {
    public static void main(String[] args) {

        EventRepository eventRepository = new EventRepository();
        UserRepository userRepository = new UserRepository();
        Processor processor = new Processor(eventRepository, userRepository);
        Thread thread = new Thread(processor);
        thread.start();

        UserService userService = new UserService(new UserAggregator(eventRepository, userRepository), new UserProjector(userRepository));
        userService.createUser("1", "John", "Smith");
        userService.createUser("2", "John", "Smith");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}

class Processor implements Runnable {
    private final Consumer consumer;
    private final EventRepository eventRepository;

    public Processor(EventRepository eventRepository, UserRepository userRepository) {
        this.consumer = new Consumer(userRepository);
        this.eventRepository = eventRepository;
    }
    public void run() {
        while (true) {
            Event event = this.eventRepository.getEvent();
            if (event != null) {
                this.consumer.dispatch(event);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}