public class OvernightShippingStrategy implements ShippingStrategy {
    private static final double BASE_COST = 120.0;
    private static final double COST_PER_KG = 10.0;
    
    @Override
    public double calculateCost(double weightKg) {
        return BASE_COST + COST_PER_KG * weightKg;
    }
}