import java.awt.*;
public class Game_Object {

    // member data
    private double x,y;
    private final Color c;

    public Game_Object(){
        x = Math.random()*600;
        y = Math.random()*600;
        c = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
    }

    public void move(){
        int r = (int)(Math.random()*12);
        if(r < 3) {
            y += 3;
        }
        else if(r < 6){
            x -= 3;
        }
        else if(r < 9){
            x += 3;
        }
        else{
            y -=3;
        }
    }


    public void paint(Graphics g){
        g.setColor(c);
        g.fillRect((int)x, (int)y, 40, 40);
    }







}
