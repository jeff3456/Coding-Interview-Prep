package interviewprep;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// Question: Program a bot that play tic tac toe perfectly.
public class TicTacToe {
  public static char[][] TTTBoard;
  private static int moveNumber;

  
  public static void main(String[] args){
    initGame();
    printBoard();
    
    while(moveNumber < 8){
      playerMove();
      printBoard();
      if(checkWin(TTTBoard) == 'x'){
        System.out.println("player wins!");
        break;
      }
      studpidBotMove();
      printBoard();
      if(checkWin(TTTBoard) == 'o'){
        System.out.println("TTTBot wins!");
        break;
      }
    }
  }
  
  
  public static void playerMove(){
    Scanner sc = new Scanner(System.in);
    int row, col;

    while(true){
      System.out.print("Which row do you want to put x in:");
      row = sc.nextInt();
      if(row < 0 || row > 2){
        System.out.println("Row out of bounds");
        continue;
      }
      System.out.print("Which col do you want to put x in:");
      col = sc.nextInt();
      if(col < 0 || col > 2){
        System.out.println("Col out of bounds");
        continue;
      }
      if(TTTBoard[row][col] == 'x' || TTTBoard[row][col] == 'o'){
        System.out.println("Invalid placement.");
      }else{
        TTTBoard[row][col] = 'x';
        break;
      }
    }
    moveNumber++;
  }
  
  // Bot that is stupid and places move randomly.
  public static void initGame(){
    TTTBoard = new char[3][3];
    moveNumber = 0;
  }
    
  public static void printBoard(){
    System.out.println(Arrays.toString(TTTBoard[0]));
    System.out.println(Arrays.toString(TTTBoard[1]));
    System.out.println(Arrays.toString(TTTBoard[2]));
  }
  
  public static void studpidBotMove(){
    // randomly choose a number from remaining positions.
    int remainingSpots = 9 - moveNumber;
    int randomSpot = ThreadLocalRandom.current().nextInt(0, remainingSpots);
    
    // iterate through board and find the randomly chosen empty spot.
    for(int row = 0; row < TTTBoard.length; row++){
      for(int col = 0; col < TTTBoard[0].length; col++){
        if(TTTBoard[row][col] == '\u0000'){
          if(randomSpot == 0){
            TTTBoard[row][col] = 'o';
            System.out.println("TTTBot places it in "+ row + "," + col);
            moveNumber++;
            return;
          }else{
            randomSpot--;
          }
        }
      }
    }
  }
  
  public static void smartBotMove(){
    char[][] boardCopy = TTTBoard.clone();
    int currentMove = moveNumber;
    
    // Create and or tree of all moves.
    
  }
  
  public static char checkWin(char[][] board){
    // Check row-wise win
    for(int row = 0; row < board.length; row++){
      if(board[row][0] != '\u0000' &&
         board[row][0] == board[row][1] && board[row][1] == board[row][2]){
        return board[row][0];
      }
    }
    // Check column-wise win
    for(int col = 0; col < board.length; col++){
      if(board[0][col] != '\u0000' &&
         board[0][col] == board[1][col] && board[1][col] == board[2][col]){
        return board[0][col];
      }
    }
    // Check diagonals
    if(board[1][1] != '\u0000' &&
       board[1][1] == board[0][0] && board[1][1] == board[2][2])
      return board[1][1];
    if(board[1][1] != '\u0000' &&
        board[1][1] == board[2][0] && board[1][1] == board[0][2])
       return board[1][1];
    return '\u0000';
  }
}
