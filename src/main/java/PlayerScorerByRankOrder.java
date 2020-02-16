public class PlayerScorerByRankOrder implements IScorer {

    public int getScore(Player player){
        int score = 0;
        for(Card card : player.getHand()){
            card.amendValueOfFaceCardsToTen();
            score += card.getRank().ordinal() + 1;
        }
        for (Card cardInHand:player.getHand()){
            if (cardInHand.getRank() == Rank.ACE && score <11){
                score += 10;
            }
        }
        return score;
    }

    public int getScore(Dealer dealer){
        int score = 0;
        for(Card card : dealer.getHand()){
            card.amendValueOfFaceCardsToTen();
            score += card.getRank().ordinal() + 1;

        }
        for (Card cardInHand:dealer.getHand()){
            if (cardInHand.getRank() == Rank.ACE && score <11){
                score += 10;
            }
        }
        return score;
    }

    public boolean isBust(Player player){
        return getScore(player) > 21;
    }

    public boolean isBust(Dealer dealer){
        return getScore(dealer) > 21;
    }
}
