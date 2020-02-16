import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    public boolean active;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.active = true;
    }

    public String getName() {
        return name;
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
