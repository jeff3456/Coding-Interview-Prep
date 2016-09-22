package interviewprep;

public class LongestCommonSubsequence {
  static int [][] mem;
  public static void main(String[] args){
    System.out.println(longestCommonSubsequence("daogzzzzzzzz", "daaaaog"));
  }
  
  public static int longestCommonSubsequence(String a, String b){
    mem = new int[a.length()][b.length()];
    for(int row = 0; row < a.length(); row++)
      for(int col = 0; col < b.length(); col++)
        mem[row][col] = -1;
    
    return longestCommonSubsequence(a, b, a.length()-1, b.length()-1);
  }
  public static int longestCommonSubsequence(String a, String b, int i, int j){
    if(i < 0 || j < 0) return 0;
    // starts at end and goes to 0.
    if(mem[i][j] != -1) return mem[i][j];
    if(a.charAt(i) == b.charAt(j)){
      mem[i][j] = 1 + longestCommonSubsequence(a, b, i-1, j-1);
      return mem[i][j];
    }
    
    mem[i][j] = Math.max(longestCommonSubsequence(a, b, i-1, j), 
                         longestCommonSubsequence(a, b, i, j-1));
    return mem[i][j];
  }
}
