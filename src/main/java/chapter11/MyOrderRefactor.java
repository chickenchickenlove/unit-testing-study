package chapter11;

import java.util.List;

public class MyOrderRefactor {

    private MyCustomer customer;
    private List<MyProduct> productList;
    private Calculator calculator;

    public String generateDescription() {
        return String.format(
                "Customer Name : %s \n" +
                        "Total number of Products : %d \n" +
                        "Total Price : %d",
                customer.getName(),
                productList.size(),
                calculator.calculate(customer, productList));
    }


    class Calculator{

        public double calculate(MyCustomer myCustomer, List<MyProduct> productList) {
            /* MyCustomer , MyProduct 기반 계산
            double basePrice = 0;
            double discounts = 0;
            double taxes = 0;
            return basePrice - discounts + taxes;
         */
        }


    }

}



