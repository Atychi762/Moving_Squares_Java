import javax.swing.*;
import java.awt.*;
public class Animation_Application extends JFrame implements Runnable{

    //member data
    private static final Dimension WindowSize = new Dimension(600, 600);
    private static final int Num_Game_Objects = 30;
    private final Game_Object[] Game_Object_Array = new Game_Object[Num_Game_Objects];
    // Constructor
    public Animation_Application(){
        // filling the game object array with new game objects
        for(int i = 0; i < Num_Game_Objects; i++){
            Game_Object_Array[i] = new Game_Object();
        }

        // Creating the window for the application
        this.setTitle("Animated squares");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension Screen_Size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = Screen_Size.width/2 - WindowSize.width/2;
        int y = Screen_Size.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);

        // Creating a thread for the application
        Thread t = new Thread(this);
        t.start();
    }

    // Implementing the run() method from the Runnable interface
    public void run(){
        // Creating the "game" loop
        while(true){
            // iterating through all the game objects and calling their move() methods
            for(int i = 0; i < Num_Game_Objects; i++){
                Game_Object_Array[i].move();
            }
            // calling repaint each iteration to redraw the objects
            repaint();
            // trying to get the thread to sleep for 20 milliseconds and catching an interrupted exception
            try{
                Thread.sleep(20);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    // overwriting the paint method from JFrame
    public void paint(Graphics g){
        // drawing a white rectangle the size of the screen to allow for window resizing without error
        Dimension Screen_Size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Screen_Size.width, Screen_Size.height);
        // looping through all the game objects calling their paint() methods
        for(int i = 0; i < Num_Game_Objects; i++){
            Game_Object_Array[i].paint(g);
        }
    }

    public static void main(String[] args){
        // creating a new instance of the Animation_Application class
        Animation_Application a = new Animation_Application();
    }
}
