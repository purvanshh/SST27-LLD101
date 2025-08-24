public class StandardShipping implements ShippingStrategy {
    public double calculate(double weightKg) {
        return 50 + 5 * weightKg;
    }
}