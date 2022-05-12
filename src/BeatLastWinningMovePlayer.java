public class BeatLastWinningMovePlayer implements Player{
    int opponentLastWinningMove;
    int move;

    public BeatLastWinningMovePlayer() {
        opponentLastWinningMove = RPS.ROCK;    // we'll start by trying to beat rock
        move = getMove();
    }

    public int getMove() {
        return getMoveToBeat(opponentLastWinningMove, move);
    }

    private int getMoveToBeat(int winprev, int move) {
        if (winprev == RPS.ROCK && move == RPS.SCISSORS) return RPS.PAPER;
        if (winprev == RPS.SCISSORS && move == RPS.PAPER) return RPS.ROCK;
        return RPS.SCISSORS;
    }

    public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
        opponentLastWinningMove = opponentMove;
    }

}
