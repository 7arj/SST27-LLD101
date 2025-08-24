public class Demo03 {
    public static void main(String[] args) {
        //shipping strategies
        ShippingStrategy standardShipping = new StandardShippingStrategy();
        ShippingStrategy expressShipping = new ExpressShippingStrategy();
        ShippingStrategy overnightShipping = new OvernightShippingStrategy();
        
        //calculator with strategy registry
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        calculator.registerStrategy("STANDARD", standardShipping);
        calculator.registerStrategy("EXPRESS", expressShipping);
        calculator.registerStrategy("OVERNIGHT", overnightShipping);
        
        //functionality demo
        System.out.println("----Shipping Cost Demo----");
        System.out.println("EXPRESS 2.0kg: $" + calculator.cost(new Shipment("EXPRESS", 2.0)));
        
        //Additional tests
        System.out.println("STANDARD 2.0kg: $" + calculator.cost(new Shipment("STANDARD", 2.0)));
        System.out.println("OVERNIGHT 2.0kg: $" + calculator.cost(new Shipment("OVERNIGHT", 2.0)));
        
        //different weight test
        System.out.println("EXPRESS 5.0kg: $" + calculator.cost(new Shipment("EXPRESS", 5.0)));
    }
}