package buoi16.collection.manager;

import buoi16.collection.event.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private Map<String, List<Event>> events;

    public EventManager(String... eventTypes) {
        this.events = new HashMap<>();
        for (String eventType : eventTypes) {
            this.events.put(eventType, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, Event event) {
        List<Event> listEvent = events.get(eventType);
        listEvent.add(event);
    }

    public void unSubscribe(String eventType, Event event) {
        List<Event> listEvent = events.get(eventType);
        listEvent.remove(event);
    }

    public void notify(String eventType, String name, String url) {
        List<Event> eventList = events.get(eventType);
        for (Event event : eventList) {
            event.notify(eventType, name, url);
        }
    }
}
