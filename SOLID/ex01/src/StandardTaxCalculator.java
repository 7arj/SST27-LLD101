public class StandardTaxCalculator implements TaxCalculator {
    private static final double TAX_RATE = 0.18;
    
    @Override
    public double calculateTotalWithTax(double subtotal) {
        return subtotal + subtotal * TAX_RATE;
    }
}