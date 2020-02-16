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
    Dealer dealer;

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

        dealer = game.getDealer();
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

    @Test
    public void gameCanCheckDraw(){
        player1.takeCard(highCard);
        player2.takeCard(highCard);
        dealer.takeCard(highCard);
        assertTrue(game.checkDraw(player1));
    }

    @Test
    public void gameCanCheckDrawAgainstMultiplePlayersAndDealer(){
        player1.takeCard(highCard);
        player2.takeCard(lowCard);
        dealer.takeCard(highCard);
        assertEquals(false, game.checkDraw(player2));
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

    @Test
    public void gameCanStartWithMultiplePlayers() {
        game.start();
        assertEquals(2, dealer.cardCount());
        assertEquals(2, player1.cardCount());
        assertEquals(2, player2.cardCount());
    }

}
