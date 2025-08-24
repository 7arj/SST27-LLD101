public class OrderController {
    private final OrderRepository repository;
    
    //inject Dependencies
    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }
    
    // Single responsibility: handle order creation request
    public void create(String id) {
        repository.save(id);
        System.out.println("Created order: " + id);
    }
}