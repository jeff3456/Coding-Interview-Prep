package interviewprep;


// Question: A child is running up a staircase with n steps 
//   and can hop either 1 step, 2 steps or 3 steps at a time.
//   implement a method to count how many possible ways the
//   child can run up the stairs.
public class StepPermutationCounter {
  public static int[] mem;
  
  public static void main(String[] args){
    testCountStepsPermutation();
  }
  
  
  public static void testCountStepsPermutation(){
    // n = 0
    System.out.println(countStepsPermutation(0));
    // n = 1
    System.out.println(countStepsPermutation(1));
    // n = 2
    System.out.println(countStepsPermutation(2));
    // n = 3
    System.out.println(countStepsPermutation(3));
    System.out.println(countStepsPermutation(4));
    System.out.println(countStepsPermutation(5));
    System.out.println(countStepsPermutation(6));
    System.out.println(countStepsPermutation(7));
    // n = 10
    System.out.println(countStepsPermutation(10));
    // n = 15
    System.out.println(countStepsPermutation(15));
    // n = 20
    System.out.println(countStepsPermutation(20));
    

  }
  
  public static int countStepsPermutation(int n){
    mem = new int[n+1];
    for(int i = 0; i < mem.length; i++) mem[i] = -1;
    
    return countStepsPermutationHelper(n);
  }
  
  private static int countStepsPermutationHelper(int n){
    if(n < 0) return 0;
    if(n == 0) return 1;
    else if(n == 1) return 1;
    else if(n == 2) return 2;

    if(mem[n] != -1) return mem[n];

    mem[n] = (countStepsPermutationHelper(n-1) +
              countStepsPermutationHelper(n-2) +
              countStepsPermutationHelper(n-3));
    
    return mem[n];
  }
  

}
