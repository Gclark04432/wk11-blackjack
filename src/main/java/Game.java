import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Deck deck;
    private IScorer scorer;
    private Dealer dealer;

    public Game(Deck deck, IScorer scorer) {
        this.players = new ArrayList<Player>();
        this.deck = deck;
        this.scorer = scorer;
        this.dealer = new Dealer();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Dealer getDealer() { return this.dealer; }

    public int playerCount() {
        return this.players.size();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void start() {
        for (Player player : this.players) {
            for (int i = 0; i < 2; i++) {
                Card card = deck.dealOne();
                card.amendValueOfFaceCardsToTen();
                player.takeCard(card);
            }
        }
        for (int i = 0; i < 2; i++) {
            Card card = deck.dealOne();
            dealer.takeCard(card);
        }
    }

    public void twist(Player player){
        Card card = deck.dealOne();
        player.takeCard(card);
    }

    public void twist(Dealer dealer){
        Card card = deck.dealOne();
        dealer.takeCard(card);
    }

    public boolean checkDraw(){
        Boolean drawGame = true;
        int dealerTotal = scorer.getScore(this.dealer);
        for (Player player:this.players) {
            int currentPlayerScore = scorer.getScore(player);
            if (currentPlayerScore != dealerTotal) {
                drawGame = false;
            }
        }
        return drawGame;
    }

    public String checkWinner(){
        int highest = 0;
        Player highestPlayer = null;
        for(Player player : this.players){
            int currentPlayerScore = scorer.getScore(player);
            if( currentPlayerScore > highest){
                highest = currentPlayerScore;
                highestPlayer = player;
            }
        }
        if (highest > scorer.getScore(dealer) && !scorer.isBust(highestPlayer)) {
            return highestPlayer.getName();
        }
        return "Dealer";
    }
}
