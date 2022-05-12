
public class RPS {
	public static final int ROCK = 0;
	public static final int PAPER = 1;
	public static final int SCISSORS = 2;
	
	public static final int YOU = 1;
	public static final int OPPONENT = 2;
	public static final int TIE = 0;
	
	private int totalGames = 0;
	private int p1wins = 0;
	private int p2wins = 0;
	
	public RPS() {
	}
	
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
	
	public double getP1Percent() {
		return (double)(p1wins*1000/totalGames)/10.0;
	}
	
	public double getP2Percent() {
		return (double)(p2wins*1000/totalGames)/10.0;
	}

	public double getTiesPercent() {
		return (double)(getTies()*1000/totalGames)/10.0;
	}
	
	public int whoWon(int p1, int p2) {
		return calcWinner(p1, p2);
	}
	
	public static int calcWinner(int p1, int p2) {
		if (p1 == p2) return 0;
		if (p1 == ROCK && p2 == PAPER) return 2;
		if (p1 == PAPER && p2 == SCISSORS) return 2;
		if (p1 == SCISSORS && p2 == ROCK) return 2;
		
		if (p2 == ROCK && p1 == PAPER) return 1;
		if (p2 == PAPER && p1 == SCISSORS) return 1;
		if (p2 == SCISSORS && p1 == ROCK) return 1;
		
		return -1;
	}
	
	public static int calcWinner(String p1, String p2) {
		return calcWinner(stringToInt(p1), stringToInt(p2));
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
	
	public static int stringToInt(String wrd) {
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
		return (winner == player)?RPS.YOU:RPS.OPPONENT;
	}
}
