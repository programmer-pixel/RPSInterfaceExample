import java.util.ArrayList;

public class GuessNextMovePlayer implements Player{
    int opponentLastMove;
    int n;
    ArrayList<Integer> result = new ArrayList<Integer>();
    ArrayList<Integer> update = new ArrayList<Integer>();
    int rockCount;
    int scissorsCount;
    int paperCount;

    public GuessNextMovePlayer() {
        opponentLastMove = RPS.ROCK;	// we'll start by trying to beat rock
        n = 5;
    }

    public int getMove() {
        return getMoveToBeat(opponentLastMove);
    }

    private int getMoveToBeat(int prev) {
        for (int i = 0; i < update.size()-1; i++) {
            if(update.get(i) == prev){
                if (prev == RPS.ROCK) return RPS.PAPER;
                if (prev == RPS.SCISSORS) return RPS.ROCK;
                return RPS.SCISSORS;
            }
            if(update.get(i) != prev && i == update.size()-2){
                int total = rockCount + scissorsCount + paperCount;
                int freq = (int)(Math.random()*total);
                if(freq <= rockCount){
                    return RPS.PAPER;
                }
                if(freq > rockCount && freq < scissorsCount + rockCount){
                    return RPS.ROCK;
                }
                return RPS.SCISSORS;
            }
        }
        return RPS.ROCK;
    }

    public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
        opponentLastMove = opponentMove;
        update.add(opponentMove);
        result.add(outcome);
        if(update.size() == n+1){
            update.remove(0);
        }
        if(result.size() == n+1){
            result.remove(0);
        }
        if(opponentMove == RPS.ROCK){
            rockCount++;
        }
        if(opponentMove == RPS.SCISSORS){
            scissorsCount++;
        }
        if(opponentMove == RPS.PAPER){
            paperCount++;
        }
    }
}
