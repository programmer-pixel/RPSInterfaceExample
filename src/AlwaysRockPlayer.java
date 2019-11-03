/***
 * This player always plays rock.
 * 
 * @author David
 *
 */
public class AlwaysRockPlayer implements Player {

	public AlwaysRockPlayer() {
		
	}

	public int getMove() {
		return RPS.ROCK;
	}

	public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {

	}

}
