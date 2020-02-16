import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player;
    Card card;

    @Before
    public void setup(){
        player = new Player("Colin");
        card = new Card(Suit.SPADES, Rank.ACE);
    }

    @Test
    public void playerHasName(){
        assertEquals("Colin", player.getName());
    }

    @Test
    public void playerStartsEmptyHanded(){
        assertEquals(0, player.cardCount());
    }

    @Test
    public void playerCanTakeCard(){
        player.takeCard(card);
        assertEquals(1, player.cardCount());
    }


    @Test
    public void playerCanShowCard(){
        player.takeCard(card);
        assertEquals("ACE of SPADES", player.showCard(0));
    }


}
