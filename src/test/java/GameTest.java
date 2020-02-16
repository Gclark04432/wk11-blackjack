import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    Player player1;
    Player player2;
    Deck deck;
    Game game;
    Card highCard;
    Card lowCard;
    IScorer scorer;

    @Before
    public void setup(){
        player1 = new Player("Colin");
        player2 = new Player("Louise");
        deck = new Deck();
        scorer = new PlayerScorerByRankOrder();
        game = new Game(deck, scorer);
        game.addPlayer(player1);
        game.addPlayer(player2);

        highCard = new Card(Suit.SPADES, Rank.KING);
        lowCard = new Card(Suit.SPADES, Rank.TWO);
    }


    @Test
    public void gameHasPlayers(){
        assertEquals(2, game.playerCount());
    }

    @Test
    public void gameCanStart(){
        game.start();
        assertEquals(2, player1.cardCount());
        assertEquals(2, player2.cardCount());
    }

//    @Test
//    public void gameCanDealMultipleCards(){
//        game.start(20);
//        assertEquals(20, player1.cardCount());
//        assertEquals(20, player2.cardCount());
//    }

    @Test
    public void gameCanCheckDraw(){
        player1.takeCard(highCard);
        player2.takeCard(highCard);
        assertTrue(game.checkDraw());
    }

    @Test
    public void gameCanCheckWinner(){
        player1.takeCard(highCard);
        player2.takeCard(lowCard);
        assertEquals(player1, game.checkWinner());
    }

    @Test
    public void playerStartsWith2Cards() {
        game.start();
        assertEquals(2, player1.cardCount());
        assertEquals(2, player2.cardCount());
    }

}
