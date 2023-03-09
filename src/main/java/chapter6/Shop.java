package chapter6;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private List<Product> itemList = new ArrayList<>();
    private int itemCount = 0;

    public void addNewProduct(Product product) {
        itemList.add(product);
    }

    public boolean isExistedInShop(Product product) {
        itemCount++;
        return itemList.contains(product);
    }


    public List<Product> getItemList() {
        return itemList;
    }
}
