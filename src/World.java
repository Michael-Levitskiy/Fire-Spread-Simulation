import java.util.Random;

public class World {
    
    ////////////////////////
    // Instance Variables //
    ////////////////////////
    private int size = 25;
    private double prob = .4;
    private boolean[][] updated;
    private Cell[][] world;
    

    /**
     * Constructor
     * @param size : the length of our 2D grid
     * @throws Exception 
     */
    public World(int size, double prob) throws Exception{
        if (size > 0) this.size = size;
        else System.out.println("Given size is <= 0, so size is set to 25");
        
        if (prob <= 1 && prob >= 0) this.prob = prob;
        else System.out.println("Given probability is < 0 or > 1, so probability is set to .4");

        this.world = new Cell[this.size][this.size];
        createWorld();     // call helper method to create the world
    }


    ///////////////
    // Accessors //
    ///////////////    
    /**
     * As this is a square world
     * @return the size for the number of columns
     */
    public int getNumColumns(){
        return this.size;
    }

    /**
     * As this is a square world
     * @return the size for the number of rows
     */
    public int getNumRows(){
        return this.size;
    }

    /**
     * Given the coordinates x,y
     * @param x for column number
     * @param y for row number
     * @return the correct cell from the world
     */
    public Cell getCell(int x, int y){
        return world[x][y];
    }


    ///////////////////
    // Public Method //
    ///////////////////
    /**
     * A tick in the World clock
     */
    public void tick(){
        // create a 2D boolean array as a way to mark which cells were already visited in each tick
        this.updated = new boolean[world.length][world[0].length];

        // loop through the matrix
        for (int x = 0; x < world.length; ++x){
            for (int y = 0; y < world[0].length; ++y){
                if (world[x][y].getState() == Cell.States.Burning && this.updated[x][y] == false){     // if the cell is burning

                    // Apply the spread method for source cell and the 8 neighboring cells
                    world[x-1][y-1] = applySpread(world[x-1][y-1], x-1, y-1, false);
                    world[x-1][y]   = applySpread(world[x-1][y], x-1, y, false);
                    world[x-1][y+1] = applySpread(world[x-1][y+1], x-1, y+1, false);
                    world[x][y-1]   = applySpread(world[x][y-1], x, y-1, false);
                    world[x][y]     = applySpread(world[x][y], x, y, true);
                    world[x][y+1]   = applySpread(world[x][y+1], x, y+1, false);
                    world[x+1][y-1] = applySpread(world[x+1][y-1], x+1, y-1, false);
                    world[x+1][y]   = applySpread(world[x+1][y], x+1, y, false);
                    world[x+1][y+1] = applySpread(world[x+1][y+1], x+1, y+1, false);
                }    
            }
        }
    }


    /////////////////////
    // Private Methods //
    /////////////////////
    /**
     * Helper method to create the 2d grid with the proper size
     */
    private void createWorld(){
        // Loop through the 2d world by nesting loops
        for (int x = 0; x < world.length; ++x){
            for (int y = 0; y < world[0].length; ++y){
                world[x][y] = new Cell();       // create a new cell

                // Check if it's a boundary cell
                if (x == 0 || y == 0 || x == (world.length - 1) || y == (world.length - 1))
                    world[x][y].setState(Cell.States.Empty);        // if so, set as empty
                else world[x][y].setState(Cell.States.Tree);        // else set as tree
            }       
        }
        // find the center of the world and set that as burning
        int mid = world.length / 2;
        world[mid][mid].setState(Cell.States.Burning);
    }

    /**
     * Get a random double from 0 to 1 for a cell
     * @param cell (Cell)
     * @return probability (double) to represent the chance of being burned
     */
    private double probCatch(Cell cell){
        Random rand = new Random();                 // define a random variable
        double probability = rand.nextDouble(1);    // get a random double from 0 to 1
        return probability;
    }

    /**
     * Find the probability of trees and set to burning if needed, change burning trees to empty
     * @param cell
     * @return the cell (Cell) whether changed or unchanged
     */
    private Cell applySpread(Cell cell, int x, int y, boolean center){
        if (cell.getState() == Cell.States.Tree){       // if it's a tree
            double rand = probCatch(cell);              // find the probability by calling helper method
            if (rand <= this.prob){                     // if rand from 0 to .45
                cell.setState(Cell.States.Burning);     // change the tree to burning
                this.updated[x][y] = true;              // mark cell as updated
            }
            
        }
        else if (cell.getState() == Cell.States.Burning && center){     // if it's burning and a the center tree
            cell.setState(Cell.States.Empty);   // change it to empty
            this.updated[x][y] = true;          // mark cell as updated
        }
        return cell;
    }
}