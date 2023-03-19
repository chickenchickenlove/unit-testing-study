package chapter8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MyUserControllerTest {

    @Test
    void changeMailFromCorporateToNonCorporate() {

        // given
        Database db = new Database();
        MyUser user = MyUserFactory.createMyUser(1,"user@mycorp.com", MyUser.UserType.EMPLOYEE);
        Company company = CompanyFactory.createCompany("mycorp.com", 1);
        MessageBus messageBus = mock(MessageBus.class);

        MyUserController myUserController = new MyUserController();

        // when
        myUserController.changeEmail(user.getUserId(), "new@gmail.com");

        // then
        MyUser findUser = Database.findUserById(user.getUserId());
        assertThat(findUser.getEmail()).isEqualTo("new@gmail.com");
        assertThat(findUser.getType()).isEqualTo(MyUser.UserType.CUSTOMER);

        Company findCompany = Database.getCompany();
        assertThat(findCompany.getNumberOfEmployee()).isEqualTo(0);

        verify(messageBus, times(1))
                .sendEmailChangedMessage1(user.getUserId(), "new@gmail.com");
    }

}