import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        IScorer scorer = new PlayerScorerByRankOrder();
        Game game = new Game(deck, scorer);
        System.out.println("Welcome to Gary's Blackjack!");
        System.out.println("How many players would like to play?");

        String input = scanner.next();
        int players = parseInt(input);

        for(int i = 0; i < players; i++){
            String prompt = String.format("Player %s, enter your name: ", (i + 1));
            System.out.println(prompt);
            String playerName = scanner.next();
            Player player = new Player(playerName);
            game.addPlayer(player);
        }


        game.start();

        Dealer dealer = game.getDealer();
        System.out.println("Dealer shows first card:");
            System.out.println(dealer.showCard(0));

            for (Player player : game.getPlayers()) {
                while (player.active == true) {
                    String output = String.format("%s has:", player.getName());
                    System.out.println(output);
                    for (int i = 0; i < player.cardCount(); i++) {
                        System.out.println(player.showCard(i));
                    }
                    System.out.println(String.format("Hand total: %s", scorer.getScore(player)));
                    if (scorer.isBust(player)){
                        System.out.println("You are bust!");
                        player.active = false;
                        break;
                    }
                    System.out.println("Stick(S) or Twist(T)?");
                    String decision = scanner.next();
                    if (decision.equals("T")) {
                        game.twist(player);
                    } else if (decision.equals("S")) {
                        player.active = false;
                    } else {
                        System.out.println("Please enter valid selection (S/T");
                    }
                }
        }
            System.out.println("Dealer shows cards: ");
            while (scorer.getScore(dealer) <16) {
                game.twist(dealer);
            }
                for (int i = 0; i < dealer.cardCount(); i++) {
                    System.out.println(dealer.showCard(i));
            }
            System.out.println(String.format("Dealer's Hand total: %s", scorer.getScore(dealer)));




        if(game.checkDraw()){
            System.out.println("It's a draw!");
        } else {
            String winner = game.checkWinner();
            String output = String.format("%s wins!", winner);
            System.out.println(output);
        }

    }
}
