public class EmailClient implements EmailSender {
    @Override
    public void send(String to, String message) {
        // ... actual email sending logic ...
        System.out.println("Email sent to " + to + ": " + message);
    }
}