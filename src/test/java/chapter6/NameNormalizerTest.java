package chapter6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
class NameNormalizerTest {

    @Test
    void test() {
        // given
        String name = "hello";
        NameNormalizer nameNormalizer = new NameNormalizer();

        // when
        int result = nameNormalizer.normalizeNameLength(name);

        // then
        assertThat(result).isEqualTo(name.length());
    }
}