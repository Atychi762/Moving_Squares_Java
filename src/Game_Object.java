import java.awt.*;

public class Game_Object {

    // member data
    private double x,y;
    private final Color c;

    public Game_Object(){
        // randomizing the starting co-ordinates on the original window
        x = Math.random()*600;
        y = Math.random()*600;
        // randomizing the colour of this game object
        c = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
    }

    // creating a move method for the animation of the object
    public void move(){
        // generating a random number and setting each of the four possible directions to a range of numbers
        int r = (int)(Math.random()*12);
        // if the number is less than 3 then the object moves down 3 pixels
        if(r < 3) {
            y += 3;
        }
        // if the number is between 3 and 6 then the object moves left 3 pixels
        else if(r < 6){
            x -= 3;
        }
        // if the number is between 6 and 9 then the object moves right 3 pixels
        else if(r < 9){
            x += 3;
        }
        // if the number is greater than 9 then the object moves up 3 pixels
        else{
            y -=3;
        }
    }

    public void paint(Graphics g){
        // drawing the square with the stored member data as parameters
        g.setColor(c);
        g.fillRect((int)x, (int)y, 40, 40);
    }







}
