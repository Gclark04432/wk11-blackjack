public class PlayerScorerByRankOrder implements IScorer {

    public int getScore(Player player){
        int score = 0;
        for(Card card : player.getHand()){
            score += card.getRank().ordinal() + 1;
        }
        return score;
    }

    public int getScore(Dealer dealer){
        int score = 0;
        for(Card card : dealer.getHand()){
            score += card.getRank().ordinal() + 1;
        }
        return score;
    }
}
