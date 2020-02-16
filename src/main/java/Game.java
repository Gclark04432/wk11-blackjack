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

    public boolean checkDraw(){
        boolean drawgame = true;
        int handTotal = scorer.getScore(this.players.get(0));
        for(Player player: this.players){
            int currentPlayerScore = scorer.getScore(player);
            if(currentPlayerScore != handTotal){
                drawgame = false;
            }
        }
        return drawgame;
    }

    public Player checkWinner(){
        int highest = 0;
        Player winner = null;
        for(Player player : this.players){
            int currentPlayerScore = scorer.getScore(player);
            if( currentPlayerScore > highest){
                highest = currentPlayerScore;
                winner = player;
            }
        }
        return winner;
    }
}
