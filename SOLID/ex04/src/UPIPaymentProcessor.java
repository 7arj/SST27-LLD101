public class UPIPaymentProcessor implements PaymentProcessor {
    @Override
    public String processPayment(double amount) {
        return "Paid via UPI: " + amount;
    }
}