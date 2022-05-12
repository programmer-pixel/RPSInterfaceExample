import java.util.Scanner;


public class HumanPlayer implements Player {
	private static Scanner keyboard;
	
	public HumanPlayer() {
		keyboard = new Scanner(System.in);
	}

	public int getMove() {
		System.out.print("Type r/p/s: ");
		String c = keyboard.next();
		
		if (c.equals("r")) return RPS.ROCK;
		if (c.equals("p")) return RPS.PAPER;
		return RPS.SCISSORS;
	}

	public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
		System.out.print("\n Winner:\t");
		if (outcome == RPS.TIE) 		System.out.println("tie"); 
		if (outcome == RPS.YOU) 		System.out.println("you"); 
		if (outcome == RPS.OPPONENT)	System.out.println("opponent"); 
	}
}
