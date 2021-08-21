package buoi16.collection.event;

import buoi16.collection.entity.Account;

public class EmailEvent implements Event  {
    private Account account;

    public EmailEvent(Account account) {
        this.account = account;
    }

    @Override
    public void notify(String eventType, String name, String url) {
        System.out.println("send message to emial is: " + account.getEmail()
                + ", name: " + name + ", url: " + url);
    }
}
