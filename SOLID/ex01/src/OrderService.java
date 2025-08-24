public class OrderService {
    private final EmailSender emailSender;

    public OrderService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void checkout(String email, double amount) {
        double tax = calculateTax(amount);
        double total = amount + tax;
        // ... business logic ...
        emailSender.send(email, "Order placed. Total: " + total);
    }

    private double calculateTax(double amount) {
        return amount * 0.18;
    }
}