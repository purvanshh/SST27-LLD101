public class OvernightShipping implements ShippingStrategy {
    public double calculate(double weightKg) {
        return 120 + 10 * weightKg;
    }
}