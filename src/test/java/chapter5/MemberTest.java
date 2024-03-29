package chapter5;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MemberTest {

    @Test
    void test1() {
        // mock
        EmailGateWay emailGateway = mock(EmailGateWay.class);

        // stub
        TestDataBase dataBase = mock(TestDataBase.class);
        when(dataBase.getData()).thenReturn("1");

        // when
        Member member = new Member();
        member.sendEmail();

        // then
        verify(emailGateway, times(1)).send(); // mock
        verify(dataBase, times(1)).getData();
    }
}