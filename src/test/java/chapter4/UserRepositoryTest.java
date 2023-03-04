package chapter4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void getByIdExecutesCorrectSQLCode() {

        UserRepository sut = new UserRepository();

        UserEntity user = sut.getById(5);

        assertThat(sut.getLastExecutedSqlStmt()).isEqualTo(
                "select * from dbo.[USER] WHERE UserID = 5");
    }
}