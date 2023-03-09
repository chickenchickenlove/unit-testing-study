package chapter5.customerexample;

import java.util.HashMap;
import java.util.Map;

public class Store {


    private final Map<String, Integer> inventory = new HashMap<>();

    public void addInventory(String item, int count) {
        inventory.put(item, count);
    }
    public boolean removeInventory(String item, int count) {
        Integer integer = inventory.get(item);
        inventory.put(item, integer - count);
        return (inventory.put(item, integer - count)) < count;
    }

    public int getInventory(String item) {
        return inventory.get(item);
    }

    public boolean hasEnoughInventory(String itemName, int count) {
        // TODO : Implementation
        return false;
    }

}
