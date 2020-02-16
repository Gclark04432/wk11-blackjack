public interface IScorer {

    int getScore(Player player);

    int getScore(Dealer dealer);

    boolean isBust(Dealer dealer);

    boolean isBust(Player player);
}