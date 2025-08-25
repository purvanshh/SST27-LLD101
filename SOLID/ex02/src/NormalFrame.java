public class NormalFrame extends Frame {
    private int firstRoll;
    private int secondRoll;

    public NormalFrame(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    @Override
    public int getScore() {
        return firstRoll + secondRoll;
    }
}