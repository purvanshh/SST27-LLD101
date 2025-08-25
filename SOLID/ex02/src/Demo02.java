// Dependency Inversion Principle: Demo02 depends on abstractions (Frame)
public class Demo02 {
    public static void main(String[] args) {
        Player player = new Player("Alice");
        Frame frame = new NormalFrame(5, 4);
        player.addScore(frame.getScore());
        System.out.println(player.getName() + " scored " + player.getScore());
    }
}
