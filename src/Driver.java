import java.util.Scanner;
import javax.swing.JFrame;

public class Driver {
    public static void main(String[] args) throws Exception {
        // Create input scanner to obtain details of forest fire from user
        Scanner input = new Scanner(System.in);
        System.out.println("How large do you want our forest?");
        int size = input.nextInt();
        System.out.println("What is the probability of a tree to catch on fire?");
        double prob = input.nextDouble();
        
        World world = new World(size, prob);                        // create the world
        Paint p = new Paint(world);                                 // paint the world
        JFrame frame = new JFrame("Forest Fire Spread Simulation"); // create a JFrame
        initUI(frame, world, p);                                    // use method to create the window

        input.close();
    }

    public static void initUI(JFrame frame, World world, Paint p){
        frame.setSize(world.getNumColumns() * Cell.width + 20, world.getNumRows() * Cell.length + 40);  // set the window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                           // allow it to be closed
        frame.setLocationRelativeTo(null);                                                              // where to put the window
        frame.add(p);                                                                                   // add the paint constructor to be in the window
        frame.setVisible(true);                                                                         // be able to see the window
    }
}