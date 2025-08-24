public class ExpressShipping implements ShippingStrategy {
    public double calculate(double weightKg) {
        return 80 + 8 * weightKg;
    }
}