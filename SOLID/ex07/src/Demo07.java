public class Demo07 {
    interface Printer {
        void print(String text);
    }

    static class BasicPrinter implements Printer {
        public void print(String text) {
            System.out.println("Print: " + text);
        }
    }

    public static void main(String[] args) {
        Printer p = new BasicPrinter();
        p.print("Hello");
        // No scan method available, so no error
    }
}
