import java.util.*;


public class PaymentService {
    private final Map<String, PaymentProcessor> processors = new HashMap<>();
    
    //dependency injection
    public void registerProcessor(String provider, PaymentProcessor processor) {
        processors.put(provider, processor);
    }
    
    //process payment 
    public String pay(Payment payment) {
        PaymentProcessor processor = processors.get(payment.provider);
        if (processor == null) {
            throw new RuntimeException("No provider");
        }
        return processor.processPayment(payment.amount);
    }
}