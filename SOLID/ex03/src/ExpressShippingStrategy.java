public class ExpressShippingStrategy implements ShippingStrategy {
    private static final double BASE_COST = 80.0;
    private static final double COST_PER_KG = 8.0;
    
    @Override
    public double calculateCost(double weightKg) {
        return BASE_COST + COST_PER_KG * weightKg;
    }
}