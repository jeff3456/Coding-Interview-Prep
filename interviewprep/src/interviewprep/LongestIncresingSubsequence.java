package interviewprep;

// Optimal substructure

// L(i) = { 1 + Max ( L(j) ) } where j < i and arr[j] < arr[i] and 
// if there is no such j then L(i) = 1

// Memoirization is the L(j) answer.
// Isn't this still O(n^2)?
// https://en.wikipedia.org/wiki/Longest_increasing_subsequence
public class LongestIncresingSubsequence {
  static int[] longSeqLenTable;
  
  public static void main(String [] args){
    int[] array = {1,2,3,4,5,6,2,2,2,2,2,2};
    System.out.println(findLongestNonDecreasingSeq(array));
  }
  
  public static int findLongestNonDecreasingSeq(int[] array){
    longSeqLenTable = new int[array.length];
    return findLongestNonDecreasingHelper(array, 0, array.length-1);
  }
  private static int findLongestNonDecreasingHelper(int[] array, int i, int j){
    int maxLength = 0;
    if(longSeqLenTable[j] != 0) return longSeqLenTable[j];
    if(i == j) return 1;
    // Find the max non descreasing subsequence from i to k 
    // make sure k is less than j
    for(int index = i; index < j; index++ ){
      for(int lastIndex = j - 1; lastIndex >= i; lastIndex-- ){
        if(array[j] >= array[lastIndex]){
          int length = findLongestNonDecreasingHelper(array, index, lastIndex);
          maxLength = (maxLength < length) ? length: maxLength;
        }
      }
    }
    
    if(maxLength != 0) longSeqLenTable[j] = maxLength;
    return maxLength + 1;
  }
}
