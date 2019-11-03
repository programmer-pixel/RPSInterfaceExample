/***
 * This player starts by playing rock.  They will continue to play that until they are beat.
 * They will then switch to whatever would have beat the opponents last throw.
 * 
 * @author David
 *
 */
public class StayIfWinSwitchIfLosePlayer implements Player {
	int prevMove;
	
	public StayIfWinSwitchIfLosePlayer() {
		prevMove = RPS.ROCK;
	}

	public int getMove() {
		return prevMove;
	}

	public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
		if (outcome == RPS.OPPONENT) {
			prevMove = getMoveToBeat(opponentMove);
		}
	}
	
	private int getMoveToBeat(int prev) {
		if (prev == RPS.ROCK) return RPS.PAPER;
		if (prev == RPS.SCISSORS) return RPS.ROCK;
		return RPS.SCISSORS;
	}
}
