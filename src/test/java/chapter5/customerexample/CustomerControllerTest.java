package chapter5.customerexample;

import chapter3.Customer;
import chapter5.EmailGateWay;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerControllerTest {

    @Test
    void purchaseSuccessWhenEnoughInventory() {

        // Mock
        EmailGateWay emailGateWay = mock(EmailGateWay.class);

        // given
        CustomerController customerController = new CustomerController(emailGateWay);

        // when
        boolean isSuccess = customerController.purchase(1, 2, 5);

        // then
        assertThat(isSuccess).isTrue();
        verify(emailGateWay, times(1)).send();
    }

    @Test
    void badTest() {

        // Mock
        Store store = mock(Store.class);
        when(store.hasEnoughInventory("shampoo", 5)).thenReturn(true);

        // given
        Customer customer = new Customer();

        // when
        boolean isSuccess = customer.purchase(store, "shampoo", 5);

        // then
        assertThat(isSuccess).isTrue();
        verify(store, times(1)).removeInventory("shampoo", 5);
    }
}