public class Demo04 {
    public static void main(String[] args) {
        Payment payment = new Payment(499);
        PaymentProvider provider = new UpiPaymentProvider();
        PaymentService service = new PaymentService(provider);
        System.out.println(service.pay(payment));
    }
}
