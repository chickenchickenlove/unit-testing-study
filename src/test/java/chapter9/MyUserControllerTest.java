package chapter9;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MyUserControllerTest {

    @Test
    void changingEmailFromCorporateToNonCorporate() {
        // given
        Database database = new Database();
        MyUser user = MyUserFactory.createMyUser(
                "user@mycopr.com", MyUser.UserType.EMPLOYEE, database);
        Company company = CompanyFactory.createCompany(
                "mycorp.com", 1, database);

        MessageBus messageBusMock = mock(MessageBus.class);
        DomainLogger loggerMock = mock(DomainLogger.class);
        MyUserController sut = new MyUserController(
                database, messageBusMock, loggerMock);

        // when
        sut.changeEmail(user.getUserId(), "new@gmail.com");

        // then
        MyUser findUser = database.getUserById(user.getUserId());
        assertThat(findUser.getEmail()).isEqualTo("mycorp.com");
        assertThat(findUser.getType()).isEqualTo(MyUser.UserType.CUSTOMER);

        Company findCompany = database.getCompany1();
        assertThat(findCompany.getNumberOfEmployee()).isEqualTo(0);

        // 정확히 몇회, 뭐가 호출되었는지 검증
        verify(messageBusMock, times(1))
                .sendEmailChangedMessage1(user.getUserId(), "new@gmail.com");

        // 다른 메서드는 호출이 없었는지 검증.
        verifyNoMoreInteractions(messageBusMock);
    }

    @Test
    void changingEmailFromCorporateToNonCorporateRefactoring() {
        // given
        Database database = new Database();
        MyUser user = MyUserFactory.createMyUser(
                "user@mycopr.com", MyUser.UserType.EMPLOYEE, database);
        Company company = CompanyFactory.createCompany(
                "mycorp.com", 1, database);

        Bus busMock = mock(Bus.class);
        MessageBus messageBus = new MessageBus(busMock);
        DomainLogger loggerMock = mock(DomainLogger.class);
        MyUserController sut = new MyUserController(
                database, messageBus, loggerMock);

        // when
        sut.changeEmail(user.getUserId(), "new@gmail.com");

        // then
        MyUser findUser = database.getUserById(user.getUserId());
        assertThat(findUser.getEmail()).isEqualTo("mycorp.com");
        assertThat(findUser.getType()).isEqualTo(MyUser.UserType.CUSTOMER);

        Company findCompany = database.getCompany1();
        assertThat(findCompany.getNumberOfEmployee()).isEqualTo(0);


        String expected = String.format("Type: USER EMAIL CHANGED;" +
                "ID: %d;" +
                "NewEmail: %s", user.getUserId(), "new@gmail.com");

        verify(busMock, times(1))
                .send(expected);
    }

    @Test
    void changingEmailFromCorporateToNonCorporateWithSpy() {
        // given
        Database database = new Database();
        MyUser user = MyUserFactory.createMyUser(
                "user@mycopr.com", MyUser.UserType.EMPLOYEE, database);
        Company company = CompanyFactory.createCompany(
                "mycorp.com", 1, database);

        SpyBus spyBus = new SpyBus();
        MessageBus messageBus = new MessageBus(spyBus);
        DomainLogger loggerMock = mock(DomainLogger.class);
        MyUserController sut = new MyUserController(
                database, messageBus, loggerMock);

        // when
        sut.changeEmail(user.getUserId(), "new@gmail.com");

        // then
        MyUser findUser = database.getUserById(user.getUserId());
        assertThat(findUser.getEmail()).isEqualTo("mycorp.com");
        assertThat(findUser.getType()).isEqualTo(MyUser.UserType.CUSTOMER);

        Company findCompany = database.getCompany1();
        assertThat(findCompany.getNumberOfEmployee()).isEqualTo(0);

        // 검증 구절이 간편해짐
        spyBus.shouldSendNumberOfMessages(1)
                .withEmailChangedMessage(user.getUserId(), "new@gmail.com");
    }

}