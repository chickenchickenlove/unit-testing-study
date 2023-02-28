package chapter3;

public class Customer {

    public boolean purchase(Store store, String item, int count) {
        return store.removeInventory(item, count);
    }
}
