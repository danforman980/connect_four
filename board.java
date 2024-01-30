//creating a board class to track the state of the game and input the tokens from both the AI and the human player
public class Board{
  private char[][] board;
//public function to set up a new board when a new game is started
  public void newboard(){
    this.board = new char[7][6];
  }
//public function to place a counter in the correct column, and then allowing the counter to fall to the lowest unfilled position
  public void placeCounter(char player, int position){
		boolean placed = false;
			for(int i=board[1].length-1; i>=0; i--){
				if(!placed){
					if(board[position-1][i] != 0){
						// skip
					}
						else {
						board[position-1][i] = player;
						placed = true;
					}
				}
			}
    }  
//public function to get the current state of the board
  public char[][] getboard(){
    return this.board;
  }
}
