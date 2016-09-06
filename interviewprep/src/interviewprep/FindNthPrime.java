package interviewprep;

// Find the nth prime number
public class FindNthPrime {
  
  public static void main(String[] args){
    testNthPrime();
  }
  
  private static void testNthPrime(){
    System.out.println("First prime " + findNthPrime(1));
    System.out.println("Second prime " + findNthPrime(2));
    System.out.println("Third prime " + findNthPrime(3));
    System.out.println("Fourth prime " + findNthPrime(4));
    System.out.println("Fifth prime " + findNthPrime(5));
    System.out.println("Sixth prime " + findNthPrime(6));

    System.out.println("50th prime " + findNthPrime(50));
    System.out.println("100th prime " + findNthPrime(100));
    System.out.println("1,000th prime " + findNthPrime(1000));
    System.out.println("10,000th prime " + findNthPrime(10000));
    System.out.println("100,000th prime " + findNthPrime(100000));

    System.out.println("10,000,000th prime " + findNthPrime(10000000));
  }
  
  
  public static int findNthPrime(int n){
    // Use the sieve function found on wikipedia
    // https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    
    // This method uses n log(n) memory.
    
    // choose sizeOfSieve to be sufficient because time complexity depends on it.
    //  n log(n)    
    int sieveSize = (int) Math.round(n * (Math.log(n) / Math.log(2)) + 10);
    boolean[] sieve = new boolean[sieveSize];
    System.out.println("size"+sieveSize);
    
    // Iterate through the sieve and perform and inner loop
    int primeCount = 0;
    int primeNum = 2;
    for(int i = 2; i < sieve.length; i++){
      if(!sieve[i]){
        primeCount++;
        if(n == primeCount){
          primeNum = i;
          break;
        }
        for(int j = i; j < sieve.length; j += i){
          sieve[j] = true;
        }
      }
    }
    return primeNum;
  }
}
