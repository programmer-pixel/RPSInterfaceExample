import java.util.ArrayList;
public class PlayToBeatInfrequentPlaysPlayer implements Player{
    int n;
    int opponentLastMove;
    int rockCount;
    int scissorsCount;
    int paperCount;
    //ArrayList<> parameter = new ArrayList<>();

    public PlayToBeatInfrequentPlaysPlayer() {
        opponentLastMove = RPS.ROCK;    // we'll start by trying to beat rock
        n = 3;
    }

    public int getMove() {
        return getMoveToBeat(opponentLastMove);
    }

    private int getMoveToBeat(int winprev) {
       int infreq = Math.min(rockCount, Math.min(scissorsCount, paperCount));
       if(infreq == rockCount){
           return RPS.PAPER;
       }
       if(infreq == scissorsCount){
           return RPS.ROCK;
       }
       return RPS.SCISSORS;
    }

    public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
        opponentLastMove = opponentMove;
        ArrayList<Integer> update = new ArrayList<Integer>();
        update.add(opponentMove);
        if(update.size() < n){
            rockCount = 0;
            scissorsCount = 0;
            paperCount = 0;
        }
        if(update.size() == n+1){
            update.remove(0);
        }
        if(opponentMove == RPS.ROCK && update.size() <= n){
            rockCount++;
        }
        if(opponentMove == RPS.SCISSORS && update.size() <= n){
            scissorsCount++;
        }
        if(opponentMove == RPS.PAPER && update.size() <= n){
            paperCount++;
        }

    }
}
