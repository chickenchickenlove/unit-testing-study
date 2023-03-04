package chapter4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserEntityTest {

    @Test
    void getterSetterTest() {

        UserEntity user = new UserEntity();

        user.setName("hello");

        Assertions.assertThat(user.getName()).isEqualTo("hello");
    }

}