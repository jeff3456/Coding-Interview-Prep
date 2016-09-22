package interviewprep;

import java.util.Arrays;

/*
 * A table composed of N x M cells, each having a certain quantity of apples, 
 * is given. 
 * You start from the upper-left corner. 
 * At each step you can go down or right one cell. 
 * Find the maximum number of apples you can collect.
 * 
 * 
 */
public class MaxApplePath {
  static int[][] appleTable;
  
  public static void main(String[] args){
    int[][] aMatrix = randomIntMatrix(0, 10, 5, 5);
    printThing(aMatrix);
    System.out.println(maxApples(aMatrix));
    
  }
  
  public static void printThing(int[][] mat){
    for(int i = 0; i < mat.length; i++){
      System.out.println(Arrays.toString(mat[i]));
    }
  }
  
  public static int[][] randomIntMatrix(int min, int max, int w, int h){
    int[][] randMatrix = new int[w][h];
    for(int row = 0; row < w; row++){
      for(int col = 0; col < h; col++){
        randMatrix[row][col] = (int) (min + max * Math.random());
      }
    }
    
    return randMatrix;
  }
  
  public static int maxApples(int[][] appleMatrix){
    appleTable = new int[appleMatrix.length][appleMatrix[0].length];
    return maxAppleHelper(appleMatrix, 0, 0);
  }
  private static int maxAppleHelper(int[][]aMatrix, int row, int col){
    if(row == aMatrix.length -1 && col == aMatrix[0].length -1) 
      return aMatrix[row][col];
    if(appleTable[row][col] != 0) 
      return appleTable[row][col];
    
    // get the max of down and left.
    int max = 0;
    if(row != aMatrix.length -1) max = maxAppleHelper(aMatrix, row + 1, col);
    if(col != aMatrix[0].length -1){
      int applesDown = maxAppleHelper(aMatrix, row, col+1);
      if(applesDown > max) max = applesDown;
    }
    appleTable[row][col] = max + aMatrix[row][col];
    return appleTable[row][col];
  }

}
