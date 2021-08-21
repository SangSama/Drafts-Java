package buoi16.collection.manager;

import buoi16.collection.event.Event;

public class AccountPage {
    private String name;
    private EventManager eventManager;

    public AccountPage(String name) {
        this.name = name;
        this.eventManager = new EventManager(FollowType.SMS_DOB, FollowType.SMS_WELCOME, FollowType.EMAIL_DOB);
    }

    public void sendSMS(String eventType, Event event) {
        eventManager.subscribe(eventType, event);
    }

    public void sendEmail(String eventType, Event event) {
        eventManager.subscribe(eventType, event);
    }

    public void removeSend(String eventType, Event event) {
        eventManager.unSubscribe(eventType, event);
    }

    public void publishSmsDob(String url) {
        eventManager.notify(FollowType.SMS_DOB, name, url);
    }

    public void publishSmsWelcome(String url) {
        eventManager.notify(FollowType.SMS_WELCOME, name, url);
    }

}
