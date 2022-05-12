public class OpponentLastMovePlayer implements Player{
    int opponentLastMove;

    public OpponentLastMovePlayer() {
        opponentLastMove = RPS.ROCK;		// we'll start by trying to beat rock
    }

    public int getMove() {
        return getMoveToBeat(opponentLastMove);
    }

    private int getMoveToBeat(int prev) {
        if (prev == RPS.ROCK) return RPS.ROCK;
        if (prev == RPS.SCISSORS) return RPS.SCISSORS;
        return RPS.PAPER;
    }

    public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
        opponentLastMove = opponentMove;
    }
}
