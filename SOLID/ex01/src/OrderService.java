public class OrderService {
    private final TaxCalculator taxCalculator;
    private final NotificationService notificationService;
    private final OrderRepository orderRepository;
    
    // Dependency injection 
    public OrderService(TaxCalculator taxCalculator, 
                       NotificationService notificationService,
                       OrderRepository orderRepository) {
        this.taxCalculator = taxCalculator;
        this.notificationService = notificationService;
        this.orderRepository = orderRepository;
    }

    public void checkout(String customerEmail, double subtotal) {
        double total = taxCalculator.calculateTotalWithTax(subtotal);
        notificationService.sendOrderConfirmation(customerEmail, total);
        orderRepository.saveOrder(customerEmail, total);
    }
}