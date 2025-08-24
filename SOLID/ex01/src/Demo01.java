public class Demo01 {
    public static void main(String[] args) {
        //Dependency injection
        TaxCalculator taxCalculator = new StandardTaxCalculator();
        NotificationService emailService = new EmailNotificationService(new EmailClient());
        OrderRepository orderRepository = new DatabaseOrderRepository();
        
        OrderService orderService = new OrderService(taxCalculator, emailService, orderRepository);
        
        // functionality demo
        orderService.checkout("a@shop.com", 100.0);
        
        System.out.println("\n=== Testing with different subtotal ===");
        orderService.checkout("test@shop.com", 250.0);
    }
}