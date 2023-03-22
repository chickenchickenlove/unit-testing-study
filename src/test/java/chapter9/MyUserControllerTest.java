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

        verify(messageBusMock, times(1))
                .sendEmailChangedMessage1(user.getUserId(), "new@gmail.com");
    }


}