import javax.swing.*;
import java.awt.*;
public class Animation_Application extends JFrame implements Runnable{

    //member data
    private static final Dimension WindowSize = new Dimension(600, 600);
    private static final int Num_Game_Objects = 30;
    private final Game_Object[] Game_Object_Array = new Game_Object[Num_Game_Objects];
    // Constructor
    public Animation_Application(){
        for(int i = 0; i < Num_Game_Objects; i++){
            Game_Object_Array[i] = new Game_Object();
        }

        this.setTitle("Animated squares");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension Screen_Size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = Screen_Size.width/2 - WindowSize.width/2;
        int y = Screen_Size.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);

        Thread t = new Thread(this);
        t.start();
    }

    public void run(){
        while(true){
            System.out.println("The thread is running");
            for(int i = 0; i < Num_Game_Objects; i++){
                Game_Object_Array[i].move();
            }
            repaint();
            try{
                Thread.sleep(20);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g){
        getContentPane().setBackground(Color.WHITE);
        for(int i = 0; i < Num_Game_Objects; i++){
            Game_Object_Array[i].paint(g);
        }
    }

    public static void main(String[] args){
        Animation_Application a = new Animation_Application();
    }
}
