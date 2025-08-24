public class ShippingCostCalculator {
    public double cost(Shipment s) {
        ShippingStrategy strategy = getStrategy(s.type);
        return strategy.calculate(s.weightKg);
    }

    private ShippingStrategy getStrategy(String type) {
        switch (type) {
            case "STANDARD": return new StandardShipping();
            case "EXPRESS": return new ExpressShipping();
            case "OVERNIGHT": return new OvernightShipping();
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
