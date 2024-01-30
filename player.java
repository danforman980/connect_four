//creating an abstract class to represent the players of the game
public abstract class player{
  //protected variables that can be used by the subclasses
  protected int pos;
  protected char colour;

  //initialising the class for use in the subclasses
  public player(char colour){
    this.colour = colour;
     }

  //function to get player position
  public int getposition() {
    return this.pos;
  } 
  
  //abstract function to allow the use of different getinput functions for the Ai and human subclasses
  public abstract void getinput(); 

  //getting colour for each player
  public char getcolour() {
    return this.colour;
  }

}
