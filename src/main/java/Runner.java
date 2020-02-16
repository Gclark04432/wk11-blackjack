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

//        System.out.println("How many cards are we playing with?");
//        int noOfCards = parseInt(scanner.next());

        game.start();

        for(Player player: game.getPlayers()){
            String output = String.format("%s has:", player.getName());
            System.out.println(output);
            for(int i = 0; i < player.cardCount(); i ++){
                System.out.println(player.showCard(i));
            }
            System.out.println(String.format("Hand total: %s", scorer.getScore(player)));
        }
        Dealer dealer = game.getDealer();
        System.out.println("Dealer has:");
        for(int i = 0; i < dealer.cardCount(); i ++){
            System.out.println(dealer.showCard(i));
        }
        System.out.println(String.format("Hand total: %s", scorer.getScore(dealer)));



        if(game.checkDraw()){
            System.out.println("It's a draw!");
        } else {
            String winner = game.checkWinner();
            String output = String.format("%s wins!", winner);
            System.out.println(output);
        }

    }
}
