public class Result {
    private int strikes;
    private int balls;

    public Result(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isCorrect(int size) {
        return strikes == size;
    }

    @Override
    public String toString() {
        return "결과: " + strikes + " 스트라이크, " + balls + " 볼";
    }
}
