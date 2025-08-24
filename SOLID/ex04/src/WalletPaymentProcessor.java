public class WalletPaymentProcessor implements PaymentProcessor {
    @Override
    public String processPayment(double amount) {
        return "Wallet debit: " + amount;
    }
}