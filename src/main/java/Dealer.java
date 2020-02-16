import java.util.ArrayList;

public class Dealer {


        private ArrayList<Card> hand;

        public Dealer() {
            this.hand = new ArrayList<Card>();
        }

        public int cardCount(){
            return this.hand.size();
        }

        public String showCard(int index){
            return this.hand.get(index).cardName();
        }

        public void takeCard(Card card){
            this.hand.add(card);
        }

        public ArrayList<Card> getHand() {
            return hand;
        }
    }

