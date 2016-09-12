package interviewprep;

/*
 * Optimal Strategy for a Game
 * Problem statement: 
 * Consider a row of n coins of values v1 . . . vn, where n is even. 
 * We play a game against an opponent by alternating turns. 
 * In each turn, a player selects either the first or last 
 * coin from the row, removes it from the row permanently, 
 * and receives the value of the coin. 
 * 
 * Determine the maximum possible amount of money we 
 * can definitely win if we move first.
 * 
 * F(i, j)  represents the maximum value the user can collect from 
         i'th coin to j'th coin.

    F(i, j)  = Max(Vi + min(F(i+2, j), F(i+1, j-1) ), 
                   Vj + min(F(i+1, j-1), F(i, j-2) )) 
Base Cases
    F(i, j)  = Vi           If j == i
    F(i, j)  = max(Vi, Vj)  If j == i+1
 */
public class CoinSelectionGame {
  public static int[] coins;
  
  public static void main(String[] args){
    coins = new int[] {8, 15, 3, 7};
    System.out.println(maxDefiniteCoinSum());

    coins = new int[] {20, 30, 2, 2, 2, 10};
    System.out.println(maxDefiniteCoinSum());
  }
  
  public static int maxDefiniteCoinSum(){
    return maxCoinSumHelper(0, coins.length-1);
  }
  
  private static int maxCoinSumHelper(int i, int j){
    //Base cases
    if(i == j) return coins[i];
    if(j == i+1) return Math.max(coins[i], coins[j]);

    return Math.max(coins[i] + Math.min(maxCoinSumHelper(i+2, j), 
                                        maxCoinSumHelper(i+1, j-1)),
                    coins[j] + Math.min(maxCoinSumHelper(i+1, j-1),
                                        maxCoinSumHelper(i, j-2)));
  }

}
