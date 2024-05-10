import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Cell_Tests {

    // reference variables to compare
    Cell testCell, other;

    // runs before each test
    @BeforeEach
    public void setup(){
        testCell = new Cell();
        other = new Cell();
    }

    @Test
    public void testSetStates(){
        // create cells with empty state
        other.setState(Cell.States.Empty);
        testCell.setState(Cell.States.Empty);
        
        // check the states and colors are the same
        assertTrue(other.getState() == testCell.getState());
        assertTrue(other.getColor() == testCell.getColor());

        // change testCell to a tree
        testCell.setState(Cell.States.Tree);

        // check the states and colors are different
        assertFalse(other.getState() == testCell.getState());
        assertFalse(other.getColor() == testCell.getColor());

        // change testCell to burning
        testCell.setState(Cell.States.Burning);

        // check the states and colors are different
        assertFalse(other.getState() == testCell.getState());
        assertFalse(other.getColor() == testCell.getColor());
    }
}