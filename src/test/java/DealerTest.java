import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    Dealer dealer;
    Card card;

    @Before
    public void setup(){
        dealer = new Dealer();
        card = new Card(Suit.SPADES, Rank.ACE);
    }

    @Test
    public void playerStartsEmptyHanded(){
        assertEquals(0, dealer.cardCount());
    }

    @Test
    public void playerCanTakeCard(){
        dealer.takeCard(card);
        assertEquals(1, dealer.cardCount());
    }


    @Test
    public void playerCanShowCard(){
        dealer.takeCard(card);
        assertEquals("ACE of SPADES", dealer.showCard(0));
    }

}
