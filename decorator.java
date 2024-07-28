interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSNotifier implements Notifier {
    private Notifier notifier;

    public SMSNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotifier implements Notifier {
    private Notifier notifier;

    public PushNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
        System.out.println("Sending Push Notification: " + message);
    }
}

// Usage
public class decorator {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifier(emailNotifier);
        Notifier pushNotifier = new PushNotifier(smsNotifier);

        pushNotifier.send("Hello, this is a notification!");
    }
}


