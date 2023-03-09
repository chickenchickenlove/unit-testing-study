package chapter6;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class EmailSenderTest {

    @Test
    void test() {
        // given
        UpstreamServer upstream = Mockito.mock(UpstreamServer.class);
        EmailSender emailSender = new EmailSender(upstream);

        // when
        emailSender.sendEmailToUpstreamServer();

        // then
        Mockito.verify(upstream, Mockito.times(1)).send();
    }
}