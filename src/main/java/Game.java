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

    public Dealer getDealer() {
        return this.dealer;
    }

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

    public void twist(Player player) {
        Card card = deck.dealOne();
        player.takeCard(card);
    }

    public void twist(Dealer dealer) {
        Card card = deck.dealOne();
        dealer.takeCard(card);
    }

    public boolean hasBlackJack(Player player) {
        return (player.cardCount() == 2 && scorer.getScore(player) == 21);
    }

    public boolean hasBlackJack(Dealer dealer) {
        return (dealer.cardCount() == 2 && scorer.getScore(dealer) == 21);
    }

    public boolean checkDraw(Player player) {
        int dealerTotal = scorer.getScore(this.dealer);
        int currentPlayerScore = scorer.getScore(player);
        return currentPlayerScore == dealerTotal;
    }

    public String checkWinner() {
        ArrayList<Player> winningPlayers = new ArrayList<Player>();
        for (Player player : this.players) {
            int dealerScore = scorer.getScore(dealer);
            int playerScore = scorer.getScore(player);
            if (!scorer.isBust(player) && (playerScore > dealerScore || scorer.isBust(dealer))) {
                winningPlayers.add(player);
            }
        }
        if (winningPlayers.size() == 0) {
            return "Dealer";
        }
        String winners = "";
        for (Player winningPlayer : winningPlayers) {
            winners = winners + winningPlayer.getName();
        }
        return winners;
    }
}