import java.util.*;

public class game{
  //classes/subclasses for use in the game
  private Board gameboard;
  private human player1;
  private AI ai;
//function to create a new game
  private void newgame(){
    //creating the three classes/subclasses for use when a new game is created
    player1 = new human('r');
    ai = new AI('y');
    gameboard = new Board();
    //creating a fresh array of the correct size for the board
    gameboard.newboard();
  }
//function to print out the current state of the board
  private void startmessage(){
    System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in"); 
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");
  }
//function to print the board
  private void printBoard(char[][] board){
		for(int i=0; i<board[1].length; i++){
			for(int j=0; j<board.length; j++){
				if(board[j][i] == 'r'){
					System.out.print("| r ");
				}
				else if(board[j][i] == 'y'){
					System.out.print("| y ");
				}
				else{
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
		System.out.println("  1   2   3   4   5   6   7");
	}
//function to check whether a player has won
  private boolean victorycheck(char player, char[][] board){
    int count = 0;
    boolean hasWon = false;
    // check verticle
    for(int i=0; i<board.length; i++){
				for(int j=0; j<board[i].length; j++){
					if(board[i][j] == player){
						count = count + 1;
						if(count >= 4){
							hasWon = true;
						}
					}
					else{
						count = 0;
					}
				}
			}
    
		// check horizontal 
    count = 0;
		for(int i=0; i<board[0].length; i++){
				for(int j=0; j<board.length; j++){
					if(board[j][i] == player){
						count = count + 1;
						if(count >= 4){
							hasWon = true;
						}
					}
					else{
						count = 0;
					}
				}
			}
    //diagonal ascending
    for (int i=3; i<board.length; i++){
        for (int j=0; j<board[0].length-3; j++){
            for (int k=0; k<4; k++){
              if (board[i-k][j+k] == player){
                count = count + 1;
                if(count >= 4){
							    hasWon = true;
						    }
              }  
					else{
						count = 0;
					}
        }
      }
    }
    //diagonal descending
    for (int i=0; i<board.length-3; i++){
        for (int j=0; j<board[0].length-3; j++){
            for (int k=0; k<4; k++){
              if (board[i+k][j+k] == player){
                count = count + 1;
                if(count >= 4){
							    hasWon = true;
						    }
              }  
					else{
						count = 0;
					}
        }
      }
    }
    return hasWon;
  }
//function to output whether the player has won or lose
  private boolean winorlose(char[][] board){
    boolean end = false;
    if (victorycheck('r', board)){
      System.out.println("You Have Won!!!");
      end = true;
      }
    else if (victorycheck('y', board)){
      System.out.println("You Have Lost!!!");
      end = true;
    }
    else{
      end = false;
    }
    return end;
  }
  //public function to check whether the column is full
  private boolean fullcheck(int position, char[][] board){
    boolean columnfull = false;
      if (board[position-1][0] != 0){
        
        columnfull = true;
      }
    return columnfull;
  }
//function to actually run and play the game
  public void playgame(){
    startmessage();
    newgame();
    boolean over = false;
    while(!over){
      player1.getinput();
      char playercolour = player1.getcolour();
      int playerpos = player1.getposition();
      //checking if the gameboard is full and selecting another column if it is
      if (fullcheck(playerpos, gameboard.getboard()) == true){
        System.out.println("column full please choose another");
        continue;
      }
      ai.getinput();
      char aicolour = ai.getcolour();
      int aipos = ai.getposition();;
      if (fullcheck(aipos, gameboard.getboard()) == true){
        continue;
      }
      else{ 
        //if the gameboard is not full placing the player tokens in the correct columns
        gameboard.placeCounter(playercolour, playerpos);
        gameboard.placeCounter(aicolour, aipos);
        printBoard(gameboard.getboard());
        over = winorlose(gameboard.getboard());
      }
    }
  }
}
