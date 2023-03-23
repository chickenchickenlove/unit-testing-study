package chapter9;

public class MessageBus {
    private BusInterface bus;

    public MessageBus(BusInterface bus) {
        this.bus = bus;
    }

    public static void sendEmailChangedMessage(int userId, String email) {

    }

    public void sendEmailChangedMessage1(int userId, String email) {
        String body = String.format("Type: USER EMAIL CHANGED;" +
                "ID: %d;" +
                "NewEmail: %s", userId, email);
        bus.send(body);
    }
}
