import java.util.*;
//subclass to control AI behaviour
public class AI extends player {
//getting the AI colour
  public AI(char colour){
    super(colour);
  }
  //getting ai position input
 @Override
 public void getinput() {
    Random random = new Random();
    this.pos = random.nextInt(7 - 1) + 1;
  }
}
