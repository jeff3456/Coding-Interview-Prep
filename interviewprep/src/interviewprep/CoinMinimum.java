package interviewprep;
//https://www.topcoder.com/community/data-science/data-science-tutorials/dynamic-programming-from-novice-to-advanced/
// Given a list of N coins, their values (V1, V2, … , VN), and the total sum S. Find the minimum number of coins the sum of which is S (we can use as many coins of one type as we want), or report that it’s not possible to select coins in such a way that they sum up to S.

public class CoinMinimum {
  static int[] sumTable;

  public static void main(String[] args){
    int [] coins = {1,3,5};
    int sum = 2;
    
    int ans = CoinCount(coins, sum);
    if(ans != Integer.MAX_VALUE) System.out.println(ans);
    else System.out.println("No ans");
  }
  
  public static int CoinCount(int[] coinsdenom, int dest){
    sumTable = new int[dest];
    for(int i = 0; i < dest; i++)
      sumTable[i] = Integer.MAX_VALUE;
    return CoinHelper(coinsdenom, 0, dest);
  }
  
  private static int CoinHelper(int[] coinsdenom, int sum, int dest){
    if (sum > dest) return Integer.MAX_VALUE;
    if (sum == dest) return 0;
    if (sumTable[sum] != Integer.MAX_VALUE) return sumTable[sum];

    int min = Integer.MAX_VALUE;
    for(int i = 0; i < coinsdenom.length; i++){
      int tempsum = coinsdenom[i] + sum;
      int numCoins = CoinHelper(coinsdenom, tempsum, dest);
      if(numCoins != Integer.MAX_VALUE)
        min = (min <= numCoins + 1) ? min : numCoins + 1;
    }

    if(min != Integer.MAX_VALUE)
      sumTable[sum] = min;
    return min;
  }
}
