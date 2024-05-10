package src;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class World_Tests {
    
    // reference variables too compare
    World testWorld, other;

    @Test
    public void testWorldSize() throws Exception{
        testWorld = new World(15, .45);
        other = new World(15, .45);

        // check the number of rows and columns are the same
        assertTrue(testWorld.getNumColumns() == other.getNumColumns());
        assertTrue(testWorld.getNumRows() == other.getNumRows());

        // change size for testWorld
        testWorld = new World(10, .45);

        // check the number of rows and columns are not the same
        assertFalse(testWorld.getNumColumns() == other.getNumColumns());
        assertFalse(testWorld.getNumRows() == other.getNumRows());
    }
}