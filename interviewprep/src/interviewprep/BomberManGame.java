package interviewprep;

import java.io.*;
import java.util.*;

public class BomberManGame {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scan.nextLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int nSeconds = Integer.parseInt(st.nextToken());
        
        int[][] arena = new int[row][col];
        
        // Initialize arena
        for(int r = 0; r < row; r++){
            String rowOfBoard = scan.nextLine();
            for(int c = 0; c < col; c++)
                arena[r][c] = (rowOfBoard.charAt(c) == 'O') ? 3 : -1;
        }
        
        // Simulation
        boolean doNothing = true;
        for(int currentTime = 1; currentTime <= nSeconds; currentTime++){
            // go through board and detonate bombs and decrement timers.
            updateArena(arena); // update at beginning of second

            if(doNothing){
                doNothing = false;
            } else{
                doNothing = true;
                // Fill grid with bombs
                fillArena(arena);
            }
        }
        printArena(arena);
    }
    
    public static void printArena(int[][] arena){
        for(int r = 0; r < arena.length; r++){
            for(int c = 0; c < arena[0].length; c++){
                if(arena[r][c] == -1)
                    System.out.print('.');
                else
                    System.out.print('O');
            }
            System.out.println("");
        }
    }
    
    public static void fillArena(int[][] arena){
        for(int r = 0; r < arena.length; r++){
            for(int c = 0; c < arena[0].length; c++){
                if(arena[r][c] == -1)
                    arena[r][c] = 3;
            }
        }
    }
    
    public static void updateArena(int[][] arena){
        // Decrement board.
        for(int r = 0; r < arena.length; r++){
            for(int c = 0; c < arena[0].length; c++){
                if(arena[r][c] > 0)
                    arena[r][c]--;
            }
        }
        
        // Go through board and destroy adjacent bombs.
        for(int r = 0; r < arena.length; r++){
            for(int c = 0; c < arena[0].length; c++){
                if(arena[r][c] == 0){
                    arena[r][c] = -1;
                    if(r > 0 && arena[r-1][c] != 0){
                        arena[r-1][c] = -1;
                    }
                    if(r < arena.length-1 && arena[r+1][c] != 0){
                        arena[r+1][c] = -1;
                    }
                    if(c > 0 && arena[r][c-1] != 0){
                        arena[r][c-1] = -1;
                    }
                    if(c < arena[0].length-1 && arena[r][c+1] != 0){
                        arena[r][c+1] = -1;
                    }
                }
            }
        }
    }
}