package chapter11;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MyCalculator {

    public int calculate(int n1, int n2) {
        return n1 + n2;
    }

    @Test
    void test() {
        // given
        MyCalculator myCalculator = new MyCalculator();
        int n1 = 1;
        int n2 = 2;
        int expected = n1 + n2; // 도메인 지식 유출

        // when
        int calculate = myCalculator.calculate(n1, n2);

        // then

        assertThat(calculate).isEqualTo(expected);
    }
}
