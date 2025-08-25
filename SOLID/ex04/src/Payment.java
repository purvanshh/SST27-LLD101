public class Payment {
    double amount;
    public Payment(double amount) { this.amount = amount; }
}

interface PaymentProvider {
    String pay(Payment payment);
}

class CardPaymentProvider implements PaymentProvider {
    public String pay(Payment payment) {
        return "Charged card: " + payment.amount;
    }
}

class UpiPaymentProvider implements PaymentProvider {
    public String pay(Payment payment) {
        return "Paid via UPI: " + payment.amount;
    }
}

class WalletPaymentProvider implements PaymentProvider {
    public String pay(Payment payment) {
        return "Wallet debit: " + payment.amount;
    }
}