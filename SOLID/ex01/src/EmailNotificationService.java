public class EmailNotificationService implements NotificationService {
    private final EmailClient emailClient;
    
    public EmailNotificationService(EmailClient emailClient) {
        this.emailClient = emailClient;
    }
    
    @Override
    public void sendOrderConfirmation(String customerEmail, double total) {
        String message = "Thanks! Your total is " + total;
        emailClient.send(customerEmail, message);
    }
}