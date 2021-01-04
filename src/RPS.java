/***
 * Class for the logic of a rock paper scissors game.  Allows for multiple plays and keeps track of total wins
 * for each player.
 */
public class RPS {
	public static final int ROCK = 0;
	public static final int PAPER = 1;
	public static final int SCISSORS = 2;
	
	public static final int P1 = 1;
	public static final int P2 = 2;
	public static final int TIE = 0;
	
	private int totalGames = 0;
	private int p1wins = 0;
	private int p2wins = 0;
	
	public RPS() {
	}

	/***
	 * Reset history of wins
	 */
	public void reset() {
		totalGames = 0;
		p1wins = 0;
		p2wins = 0;
	}
	
	public int getTotalGames() {
		return totalGames;
	}

	public int getP1wins() {
		return p1wins;
	}

	public int getP2wins() {
		return p2wins;
	}

	/***
	 * Get percent of all games which p1 has won
	 * @return percent of all games which p1 has won
	 */
	public double getP1Percent() {
		if (totalGames == 0) return 0;
		return (double)(p1wins*totalGames/totalGames)/10.0;
	}

	/***
	 * Get percent of all games which p2 has won
	 * @return percent of all games which p2 has won
	 */
	public double getP2Percent() {
		if (totalGames == 0) return 0;
		return (double)(p2wins*totalGames/totalGames)/10.0;
	}

	/***
	 * Get percent of all games which have been ties
	 * @return percent of all games which have been ties
	 */
	public double getTiesPercent() {
		if (totalGames == 0) return 0;
		return (double)(getTies()*totalGames/totalGames)/10.0;
	}

	/***
	 * Determine the winner for one set of throws.
	 * @param p1Move the move for player 1 (must be RPS.ROCK, RPS.PAPER, or RPS.SCISSORS)
	 * @param p2Move the move for player 2 (must be RPS.ROCK, RPS.PAPER, or RPS.SCISSORS)
	 * @return RPS.P1, RPS.P2 or RPS.TIE
	 */
	public int whoWon(int p1Move, int p2Move) {
		return calcWinner(p1Move, p2Move);
	}

	/***
	 * Determine the winner for one set of throws.
	 * @param p1Move the move for player 1 (must be RPS.ROCK, RPS.PAPER, or RPS.SCISSORS)
	 * @param p2Move the move for player 2 (must be RPS.ROCK, RPS.PAPER, or RPS.SCISSORS)
	 * @return RPS.P1, RPS.P2 or RPS.TIE
	 */
	private static int calcWinner(int p1Move, int p2Move) {
		if (p1Move == p2Move) return RPS.TIE;
		if (p1Move == ROCK && p2Move == PAPER) return RPS.P2;
		if (p1Move == PAPER && p2Move == SCISSORS) return RPS.P2;
		if (p1Move == SCISSORS && p2Move == ROCK) return RPS.P2;
		
		if (p2Move == ROCK && p1Move == PAPER) return RPS.P1;
		if (p2Move == PAPER && p1Move == SCISSORS) return RPS.P1;
		if (p2Move == SCISSORS && p1Move == ROCK) return RPS.P1;
		
		return -1;
	}

	/***
	 * Determine the winner for one set of throws.
	 * @param p1Move the move for player 1 (must be "rock", "paper", or "scissors")
	 * @param p2Move the move for player 2 (must be "rock", "paper", or "scissors")
	 * @return RPS.P1, RPS.P2 or RPS.TIE
	 */
	private static int calcWinner(String p1Move, String p2Move) {
		return calcWinner(stringToInt(p1Move), stringToInt(p2Move));
	}
	
	public int whoWon(String p1, String p2) {
		return calcWinner(stringToInt(p1), stringToInt(p2));
	}
	
	public static String intToString(int num) {
		if (num == ROCK) return "rock    ";
		if (num == PAPER) return "paper   ";
		if (num == SCISSORS) return "scissors";
		return "error";
	}

	/***
	 * Convert string representing move to corresponding constant.
	 * @param wrd String representing move ("rock", "paper", or "scissors")
	 * @return corresponding constant
	 */
	private static int stringToInt(String wrd) {
		wrd = wrd.trim().toLowerCase();
		if (wrd.contains("rock")) return ROCK;
		if (wrd.contains("paper")) return PAPER;
		if (wrd.contains("scissors")) return SCISSORS;
		return -1;
	}

	public int playRound(int humanMove, int compMove) {
		totalGames++;
		int winner = calcWinner(humanMove, compMove);
		if (winner == 1) this.p1wins++;
		if (winner == 2) this.p2wins++;
		
		return winner;
	}

	public static String getWinnerString(int winner) {
		if (winner == 1) return "P1 Wins";
		if (winner == 2) return "P2 Wins";
		return "Tie";
	}

	public int getTies() {
		return (totalGames - this.getP1wins() - this.getP2wins());
	}

	public static String getWinnerStringFor(int player, int winner) {
		if (winner == RPS.TIE) return "Tie";
		return (winner == player)?"You":"Opponent";
	}
	
	public static int getWinnerFor(int player, int winner) {
		if (winner == RPS.TIE) return RPS.TIE;
		return (winner == player)?RPS.P1 :RPS.P2;
	}
}
