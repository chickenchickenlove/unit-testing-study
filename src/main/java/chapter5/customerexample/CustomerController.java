package chapter5.customerexample;

import chapter3.Customer;
import chapter3.Store;
import chapter5.EmailGateWay;

public class CustomerController {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final chapter3.Store store;
    private final EmailGateWay emailGateWay;

    public CustomerController(CustomerRepository customerRepository, ProductRepository productRepository, Store store, EmailGateWay emailGateWay) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.store = store;
        this.emailGateWay = emailGateWay;
    }

    public boolean purchase(int customerId, int productId, int quantity) {

        Customer customer = customerRepository.getById(customerId);
        Product product = productRepository.getById(productId);

        boolean isSuccess = customer.purchase(store, product.toString(), quantity);

        if (isSuccess) {
            emailGateWay.send();
        }

        return isSuccess;
    }
}
