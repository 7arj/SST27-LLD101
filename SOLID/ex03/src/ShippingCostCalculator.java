import java.util.*;

public class ShippingCostCalculator {
    private final Map<String, ShippingStrategy> strategies = new HashMap<>();
    
    public void registerStrategy(String type, ShippingStrategy strategy) {
        strategies.put(type, strategy);
    }
    
    // Calculate cost
    public double cost(Shipment shipment) {
        ShippingStrategy strategy = strategies.get(shipment.type);
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown type: " + shipment.type);
        }
        return strategy.calculateCost(shipment.weightKg);
    }
}