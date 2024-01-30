import java.io.BufferedReader;
import java.io.InputStreamReader;

//player subclass to get the position input from the player
public class human extends player {
//getting the colour function from the superclass
  public human(char colour){
    super(colour);
  }
  
//override function to get human input from keyboard
 @Override
 public void getinput() {
   BufferedReader input;
	 String toReturn = null;
   //loop to only store input positon if within bounds
   while (true){
		try{			
      input = new BufferedReader(new InputStreamReader(System.in));
			toReturn = input.readLine();
		}
		catch(Exception e){
			
		}
    int move = Integer.parseInt(toReturn);
   //checking to make sure the position input is within bounds
    if(move >= 0 && move < 8){
      //breaking loop and storing position data if player position is within bounds
     this.pos = move;
      break;
    }
    else{
      System.out.println("outside of grid");
    }  
   }
	} 
}
