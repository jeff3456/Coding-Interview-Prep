package interviewprep;
import java.util.HashSet;

/*
 * Question: Find pairs in an integer array whose sum is equal to 10 
 * (bonus: do it in linear time)
 */
public class FindSumPairs {
  
  public static void main(String[] args){
    testFindArraySum();
  }
  
  private static void testFindArraySum(){
    // Test cases.
    int targetSum = 10;
    // the 0 complement
    int[] test0 = {0, 10};
    findArraySumPair(test0, targetSum);
    
    // negative numbers
    int[] test1 = {-1, 11, -2, -3, 2, 3, 4, 5, 12, 13};
    findArraySumPair(test1, targetSum);
    
    // same number 5 + 5 = 10 where 10 is the target number
    int[] test2 = {5, 5};
    findArraySumPair(test2, targetSum);
  }

  public static void findArraySumPair(int[] arr, int targetSum){
    // try to accomplish this is linear time. 
    // Only parse through array linearly
    
    // Brute force way to do it:
    // start with first element and try all other elements in the array
    // move on to the next element with the same logic. O(n^2)
    
    // Easier more efficient HashSet way to do it: O(n)
    // map the complementary value to the current element for the targetSum.
    // e.g.: targetSum = 10, and currentElmt = 2, then mapValue = 10 - 2 = 8
    // if such a value is found in the set, print it out.
    // This method also accommodates negative numbers.
    
    HashSet<Integer> complementaryIntSet = new HashSet<Integer>();
    for(int currentInt : arr){
      if(complementaryIntSet.contains(currentInt)){
        System.out.println(currentInt);
      } else{
        // add the complement to the set
        complementaryIntSet.add(targetSum - currentInt);
      }
    }
    
  }
}
