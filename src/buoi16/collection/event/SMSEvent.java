package buoi16.collection.event;

import buoi16.collection.entity.Account;

/*
* Sẽ có rất nhiều event, mỗi event là 1 chanel
*
*
* */

public class SMSEvent implements Event {
    private Account account;

    public SMSEvent() {
    }

    public SMSEvent(Account account) {
        this.account = account;
    }

    @Override
    public void notify(String eventType, String name, String url) {
        System.out.println("sms send to phone is: " + account.getPhone()
                + ", name: " + name + ", content: " + eventType + ", url: " + url);
    }
}
