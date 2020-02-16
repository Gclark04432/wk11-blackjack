public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Rank amendValueOfFaceCardsToTen() {
        if (this.rank.getIsFaceCard()) {
            this.rank = Rank.TEN;
        }
        return this.rank;
    }


    public String cardName(){
        return String.format("%s of %s", this.rank, this.suit);
    }
}
