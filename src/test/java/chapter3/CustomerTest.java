package chapter3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerTest {

    @Test
    void purchaseSucceedsWhenEnoughInventory() {

        // given
        String item = "shampoo";
        Store store = new Store();
        store.addInventory(item, 10);
        Customer sut = new Customer();

        // when
        boolean success = sut.purchase(store, item, 10);
        store.removeInventory(item, 10);

        // then
        assertThat(success).isTrue();
        assertThat(store.getInventory(item)).isEqualTo(5);
    }

    @Test
    void purchaseFailsWhenNotEnoughInventory() {

        // mock
        Store store = spy(Store.class);
        when(store.hasEnoughInventory("shampoo", 5)).thenReturn(false);
        Customer sut = new Customer();

        sut.purchase(store, "shampoo", 5);

        verify(store, never()).removeInventory("shampoo", 5);
    }


    @Test
    void purchaseSucceedsWhenEnoughInventoryBadCase() {

        // given
        badFixture();

        // when
        boolean success = sut.purchase(store, item, 10);
        store.removeInventory(item, 10);

        // then
        assertThat(success).isTrue();
        assertThat(store.getInventory(item)).isEqualTo(5);
    }

    String item;
    Store store;
    Customer sut;

    void badFixture() {
        this.item = "ITEM";
        this.store = new Store();
        this.sut = new Customer();
        store.addInventory(item, 10);
    }

    void initializeItemAndStore(String itemName, int count) {
        this.item = itemName;
        this.store = new Store();
        this.sut = new Customer();
        store.addInventory(item, count);
    }

}