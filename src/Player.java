public interface Player {

    // return your player's move.  The value should be one of
    //     RPS.ROCK, RPS.PAPER, or RPS.SCISSORS
    public int getMove();

    /* This method will be called by the Game object to tell
     * your player
     * both moves and the outcome of the previous round.
     *
     * yourMove and opponentMove will both be one of:
     * RPS.ROCK, RPS.PAPER, or RPS.SCISSORS
     * outcome will be:  RPS.YOU, RPS.OPPONENT, or RPS.TIE */
    public void updateLastRoundInfo(int yourMove,
                                    int opponentMove,
                                    int outcome);
}
