import com.example.orders.*;

public class TryIt {
    public static void main(String[] args) {
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);
        Order o = new Order.Builder("o2", "a@b.com")
            .addLine(l1)
            .addLine(l2)
            .discountPercent(10)
            .build();
        System.out.println("Before: " + o.totalAfterDiscount());
        // l1.setQuantity(999); // Not possible: OrderLine is now immutable
        System.out.println("After:  " + o.totalAfterDiscount());
        System.out.println("=> In the solution, totals remain stable due to defensive copies and immutability.");
    }
}
