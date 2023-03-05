package main.java.com.cqrs.Repositories;

import main.java.com.cqrs.Events.Event;

import java.util.*;

public class EventRepository {
    private Queue<Event> store = new LinkedList<>();
    public void addEvent(Event event) {
        store.add(event);
    }

    public Event getEvent() {
        if (store.isEmpty()) {
            return null;
        }
        return store.poll();
    }
}
