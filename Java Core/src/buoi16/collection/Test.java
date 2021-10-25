package buoi16.collection;

import buoi16.collection.entity.Account;
import buoi16.collection.event.EmailEvent;
import buoi16.collection.event.SMSEvent;
import buoi16.collection.manager.AccountPage;
import buoi16.collection.manager.FollowType;

public class Test {
    public static void main(String[] args) {
        Account sondx = Account.builder()
                .name("sondx")
                .phone("0399088714")
                .email("sondx@gmail.com")
                .build();

        Account kientt = Account.builder()
                .name("kientt")
                .phone("0987654321")
                .email("kientt@gmail.com")
                .build();

        SMSEvent smsEvent = new SMSEvent(sondx);
        SMSEvent smsEvent1 = new SMSEvent(kientt);
        EmailEvent emailEvent = new EmailEvent(kientt);

        AccountPage accountPage = new AccountPage("sondx");
        accountPage.sendSMS(FollowType.SMS_WELCOME, smsEvent);
        accountPage.sendSMS(FollowType.SMS_DOB, smsEvent1);
        accountPage.sendSMS(FollowType.SMS_DOB, smsEvent);

        accountPage.publishSmsWelcome("http://daoxuanson.com/welcome");
        accountPage.publishSmsDob("http://daoxuanson.com");

    }
}
