package src;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Paint extends JPanel implements ActionListener{
    
    private final int delay = 100;  // delay for the ActionListener
    private Timer timer;            // object to control when to repaint
    private World world;            // object to hold the 2d world


    /**
     * Constructor
     * @param world (World)
     */
    public Paint(World world){
        this.world = world;
        initTimer();
    }


    /**
     * Accessor
     * @return the timer
     */
    public Timer getTimer(){
        return this.timer;
    }


    ////////////////////////
    // Overridden Methods //
    ////////////////////////
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent arg8){
        repaint();
    }

    ////////////////////////////
    // Private Helper Methods //
    ////////////////////////////
    /**
     * Draw the world for each cell in the 2d array
     * @param g (Graphics)
     */
    private void doDrawing(Graphics g){
        // create the 2-dimensional graphics
        Graphics g2d = (Graphics2D) g;

        // draw the world as a series of rectangles
        // loop through the world
        for (int x = 0; x < world.getNumRows(); x++){
            for (int y = 0; y < world.getNumColumns(); y++){
                Cell cell = world.getCell(x,y);                                         // get the cell
                g2d.setColor(cell.getColor());                                          // set the color as the cell
                g2d.fillRect(y*Cell.width, x*Cell.length, Cell.width, Cell.length);     // fill a rectangle
            }
        }
        // use tick method to update world
        world.tick();
    }

    /**
     * Initiate the timer
     */
    private void initTimer(){
        timer = new Timer(delay, this);
        timer.start();
    }
}