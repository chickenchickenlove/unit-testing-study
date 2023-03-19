package chapter8;

public class ReportGenerationService {
    public void generateReport(int orderId, CheckoutService checkoutService) {

        // ...
        checkoutService.callBack();
    }
}
