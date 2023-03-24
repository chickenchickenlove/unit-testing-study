package chapter11;

import java.util.List;

public class MyOrder {

    private MyCustomer customer;
    private List<MyProduct> productList;


    public String generateDescription() {
        return String.format(
                "Customer Name : %s \n" +
                        "Total number of Products : %d \n" +
                        "Total Price : %d",
                customer.getName(),
                productList.size(),
                getPrice()
        );
    }

    private double getPrice() {
        /*
        double basePrice = 0;
        double discounts = 0;
        double taxes = 0;
        return basePrice - discounts + taxes;
         */
    }

}
