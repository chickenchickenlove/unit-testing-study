package chapter8;

public class CheckoutService {

    public void checkOut(int orderId) {
        ReportGenerationService reportGenerationService = new ReportGenerationService();
        reportGenerationService.generateReport(orderId, this);
        /* 기타 코드 */
    }

    public void callBack() {
        // ...
    }
}
