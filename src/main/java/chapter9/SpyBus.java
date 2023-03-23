package chapter9;

import org.assertj.core.api.Assertions;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SpyBus implements BusInterface {

    private List<String> sentMessages = List.of();

    @Override
    public void send(String body) {

    }


    public SpyBus shouldSendNumberOfMessages(int number) {
        assertThat(sentMessages.size()).isEqualTo(number);
        return this;
    }

    public SpyBus withEmailChangedMessage(int userId, String newEmail) {
        String expected = String.format("Type: USER EMAIL CHANGED;" +
                "ID: %d;" +
                "NewEmail: %s", userId, newEmail);
        assertThat(sentMessages).contains(expected);
        return this;
    }
}
