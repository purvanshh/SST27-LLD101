public class Demo06 {
    public static void main(String[] args) {
        Aviary aviary = new Aviary();
        aviary.release(new Flyable() {
            public void fly() { System.out.println("Flap!"); }
        });
        // Penguin does not implement Flyable, so do not pass to release
    }
}
