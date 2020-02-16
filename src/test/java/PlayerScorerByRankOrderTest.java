import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerScorerByRankOrderTest {


    @Test
    public void testScoreForKings(){
        Card king = new Card(Suit.DIAMONDS, Rank.KING);
        Player player = new Player("Alex");
        player.takeCard(king);
        player.takeCard(king);
        IScorer scorer = new PlayerScorerByRankOrder();
        int actualScore = scorer.getScore(player);
        assertEquals(26, actualScore);
    }

    @Test
    public void testScoreForAces(){
        Card ace = new Card(Suit.DIAMONDS, Rank.ACE);
        Player player = new Player("Alex");
        player.takeCard(ace);
        player.takeCard(ace);
        IScorer scorer = new PlayerScorerByRankOrder();
        int actualScore = scorer.getScore(player);
        assertEquals(2, actualScore);
    }


}
