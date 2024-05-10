package src;
import java.awt.Color;

public class Cell {

    // variables that matches color with the corresponding cell state
    public static final Color[] Colors = {Color.YELLOW, Color.GREEN, Color.RED};
    public static enum States {Empty, Tree, Burning};
    
    ////////////////////////
    // Instance Variables //
    ////////////////////////
    public static final int length = 10;
    public static final int width = 10;
    private States state;
    private Color color;
    

    /**
     * Null Constructor
     */
    public Cell(){
        this.state = States.Empty;
        this.color = Colors[this.state.ordinal()];
    }

    
    ///////////////////////////
    // Accessors and Mutator //
    ///////////////////////////
    /**
     * @param new_state : the state to change to
     * Change 'this' state and color to correctly match the state
     */
    public void setState(States new_state){
        this.state = new_state;
        this.color = Colors[this.state.ordinal()];
    }

    /**
     * @return the state
     */
    public States getState(){
        return this.state;
    }

    /**
     * @return the color
     */
    public Color getColor(){
        return this.color;
    }
}