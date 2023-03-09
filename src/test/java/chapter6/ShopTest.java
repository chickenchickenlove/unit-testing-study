package chapter6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void test() {
        // given
        Product product = new Product();
        Shop sut = new Shop();

        // when
        sut.addNewProduct(product);

        // then
        assertThat(sut.getItemList().size()).isEqualTo(1);
    }

}