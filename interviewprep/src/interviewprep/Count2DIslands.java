package interviewprep;

import java.util.Arrays;

// HARD: Given a 2D array of 1s and 0s, count 
//   the number of "islands of 1s" (e.g. groups of connecting 1s)
public class Count2DIslands {
  
  public static void main(String[] args){
    int[][] test = {{1,0,1},
                    {0,1,0},
                    {1,0,1}};
    System.out.println(countIslands2D(test));
  }

  // Iterate through the array sequentially and perform a BFS every time oyu
  public static int countIslands2D(int[][] array){
    return countIslands2D(array, 1, 0);
  }

  public static int countIslands2D(int[][] array, int island, int water){
    int numIslands = 0;
    
    boolean[][] visited = new boolean [array.length][array[0].length];
    for(int row = 0; row < array.length; row++){
      for(int col = 0; col < array[0].length; col++){
        if(!visited[row][col]){
          if(array[row][col] == island){
            numIslands++;
            // BFS marking 1's as visited
            BFSVisited(array, visited, row, col, island);            
          }
        }
      }
    }
    
    return numIslands;
  }
  private static void BFSVisited(int[][] array, boolean[][] visited, 
                                 int row, int col, int island){
    if(array[row][col] == island){
      visited[row][col] = true;
      // call on all 4 directions if true
      if(row < array.length - 1 &&
          array[row+1][col] == island && visited[row+1][col] == false){
        BFSVisited(array, visited, row+1, col, island);
      }
      if(row > 0 &&
          array[row-1][col] == island && visited[row-1][col] == false){
        BFSVisited(array, visited, row+1, col, island);
      }
      if(col < array[0].length - 1 &&
          array[row][col+1] == island && visited[row][col+1] == false){
        BFSVisited(array, visited, row+1, col, island);
      }
      if(col > 0 &&
          array[row][col-1] == island && visited[row][col-1] == false){
        BFSVisited(array, visited, row+1, col, island);
      }
    }
  }
}
