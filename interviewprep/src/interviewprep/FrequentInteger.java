package interviewprep;
import java.util.HashMap;;


/*
 * Question: Find the most frequent integer in an array.
 */
public class FrequentInteger {

  public static void main(String[] args) {
    try{
      int[] test0 = {};
      System.out.println(mostFrequentInteger(test0));

    } catch (ArrayIndexOutOfBoundsException e){
      System.out.println("error msg: " + e.getMessage());
    }
    
    int[] test1 = {1};
    System.out.println(mostFrequentInteger(test1));
    
    int[] test2 = {1,2,2};
    System.out.println(mostFrequentInteger(test2));

    int[] test3 = {1,2,2,1,1};
    System.out.println(mostFrequentInteger(test3));
    
    int[] test4 = {1,2,2,1,3,4,5,5,5,5,5,6,7,4,3,4,21,1,2,2,3,10293,4,5,5,1};
    System.out.println(mostFrequentInteger(test4));

  }
  
  public static int mostFrequentInteger(int[] arr){

    // if the length of the array is too small throw exception.
    if(arr.length <= 0){
      throw new ArrayIndexOutOfBoundsException();
    }

    int mostFrequent = Integer.MAX_VALUE;
    int maxFrequency = 0;
    // iterate through array while keeping track of elements that
    //   have already been visited
    // need O(1) lookup for integer so use HashMap
    HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    for(int integer : arr){
      if(frequencyMap.containsKey(integer)){
        int currentCount = frequencyMap.get(integer) + 1;
        frequencyMap.put(integer, currentCount);
        if(currentCount > mostFrequent){
          // update max frequency and most frequent number
          mostFrequent = integer;
          maxFrequency = currentCount;
        }
      } else {
        frequencyMap.put(integer, 1);
        if(mostFrequent == Integer.MAX_VALUE){
          mostFrequent = integer;
          maxFrequency = 1;
        }
      }
    }

    return mostFrequent;
  }
}
