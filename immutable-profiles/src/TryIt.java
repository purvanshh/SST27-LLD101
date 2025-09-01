import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();
        UserProfile p = svc.createMinimal("u1", "a@b.com");
        System.out.println("Email: " + p.getEmail());
        // Uncommenting the next line will cause a compile error, demonstrating immutability:
        // p.setEmail("evil@example.com");
        UserProfile p2 = svc.withDisplayName(p, "Alice Wonderland");
        System.out.println("Display Name: " + p2.getDisplayName());
        System.out.println("=> The object is now immutable. Updates return a new instance.");
    }
}
