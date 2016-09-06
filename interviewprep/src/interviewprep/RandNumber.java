package interviewprep;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

// HARD: Given a function rand5() that 
//   returns a random int between 0 and 5, implement rand7()

public class RandNumber {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    // MY INCORRECT SOLUTION
    int[] intFrequency = new int[10];
    for (int i = 0; i < 1000; i++){
      intFrequency[rand7()]++;
    }    
    
    System.out.println(Arrays.toString(intFrequency));
    
    for(int i = 0; i < intFrequency.length; i++){
      intFrequency[i] = 0;
    }
    for (int i = 0; i < 1000; i++){
      intFrequency[rand5()]++;
    }

    System.out.println(Arrays.toString(intFrequency));
    
    // CORRECT SOLUTION
    for(int i = 0; i < intFrequency.length; i++){
      intFrequency[i] = 0;
    }
    for (int i = 0; i < 1000; i++){
      intFrequency[rand7sol()]++;
    }    
    
    System.out.println(Arrays.toString(intFrequency));

  }
  
  // Implement rand7 with rand5?
  // This is probabilistically incorrect.
  public static int rand7(){
    return (rand5() +
        rand5() +
        rand5() +
        rand5() +
        rand5() +
        rand5() +
        rand5()) / 5;
  }
  
  // one solution
  public static int rand7sol(){
    int[][] vals = {
        { 1, 2, 3, 4, 5 },
        { 6, 7, 1, 2, 3 },
        { 4, 5, 6, 7, 1 },
        { 2, 3, 4, 5, 6 },
        { 7, 0, 0, 0, 0 }
    };
    int result = 0;
    while (result == 0){
        int i = rand5();
        int j = rand5();
        result = vals[i-1][j-1];
    }
    return result;
  }

  public static int rand5(){
    return ThreadLocalRandom.current().nextInt(1, 5 + 1);
  }
}
