public class BeatByFrequencyPlayer implements Player{
    int opponentLastMove;
    int rockCount;
    int scissorsCount;
    int paperCount;

    public BeatByFrequencyPlayer() {
        opponentLastMove = RPS.ROCK;
    }

    public int getMove() {
        return getMoveToBeat(opponentLastMove);
    }

    private int getMoveToBeat(int winprev) {
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

    public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
        opponentLastMove = opponentMove;
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
