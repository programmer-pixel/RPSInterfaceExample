/***
 * This player will always play whatever would have beat the previous
 * move of the opponent.
 * 
 * @author David
 *
 */
public class BeatLastMovePlayer implements Player {
	int opponentLastMove;
	
	public BeatLastMovePlayer() {
		opponentLastMove = RPS.ROCK;		// we'll start by trying to beat rock
	}

	public int getMove() {
		return getMoveToBeat(opponentLastMove);
	}

	private int getMoveToBeat(int prev) {
		if (prev == RPS.ROCK) return RPS.PAPER;
		if (prev == RPS.SCISSORS) return RPS.ROCK;
		return RPS.SCISSORS;
	}

	public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
		opponentLastMove = opponentMove;
	}

}
