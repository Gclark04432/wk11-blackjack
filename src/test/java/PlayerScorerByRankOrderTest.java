import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

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
        assertEquals(20, actualScore);
    }

    @Test
    public void testAceCanBe1IfScoreTooHighFor11(){
        Card ace = new Card(Suit.DIAMONDS, Rank.ACE);
        Card queen = new Card(Suit.DIAMONDS, Rank.QUEEN);
        Card three = new Card(Suit.DIAMONDS, Rank.THREE);
        Player player = new Player("Alex");
        player.takeCard(ace);
        player.takeCard(queen);
        player.takeCard(three);
        IScorer scorer = new PlayerScorerByRankOrder();
        int actualScore = scorer.getScore(player);
        assertEquals(14, actualScore);
    }

    @Test
    public void testAceCanBe11IfScoreLowEnough(){
        Card ace = new Card(Suit.DIAMONDS, Rank.ACE);
        Player player = new Player("Alex");
        player.takeCard(ace);
        IScorer scorer = new PlayerScorerByRankOrder();
        int actualScore = scorer.getScore(player);
        assertEquals(11, actualScore);
    }


}
