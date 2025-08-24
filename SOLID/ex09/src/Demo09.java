public class Demo09 {
    public static void main(String[] args) {
        System.out.println("---- Order Service Demo ----");
        
        // dependencies
        OrderRepository sqlRepo = new SqlOrderRepository();
        OrderRepository mongoRepo = new MongoOrderRepository();
        
        OrderController sqlController = new OrderController(sqlRepo);
        OrderController mongoController = new OrderController(mongoRepo);
        
        //functionality demo
        sqlController.create("ORD-1");
        mongoController.create("ORD-2");

        System.out.println("\n---- Multiple Orders Demo ----");
        sqlController.create("ORD-3");
        sqlController.create("ORD-4");
    }
}