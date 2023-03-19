package chapter7.refactor2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MyUserTest {


    @Test
    void changeEmailFromCorporateToNonCorporate() {
        // given
        Company company = new Company("mycorp.com", 1);
        MyUser sut = new MyUser(1, "user@gmail.com", MyUser.UserType.CUSTOMER);

        // when
        sut.changeEmail("new@myCorp.com", company);

        // then
        assertThat(2).isEqualTo(company.getNumberOfEmployee());
        assertThat("new@mycorp.com").isEqualTo(sut.getEmail());
        assertThat(MyUser.UserType.EMPLOYEE).isEqualTo(sut.getType());
    }


}