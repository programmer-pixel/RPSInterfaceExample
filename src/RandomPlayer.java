public class RandomPlayer implements Player {

    public int getMove() {
        int num = (int)(Math.random()*3);
        if (num == 0) return RPS.ROCK;
        if (num == 1) return RPS.PAPER;
        return RPS.SCISSORS;
    }

    public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
        // no need to save info
    }
}
