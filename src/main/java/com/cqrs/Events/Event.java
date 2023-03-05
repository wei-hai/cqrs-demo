package main.java.com.cqrs.Events;

import java.util.Date;
import java.util.UUID;

public abstract class Event {
    public final UUID id = UUID.randomUUID();
    public final Date created = new Date();
}
