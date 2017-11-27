

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HealthyObjectTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */




public class HealthyObjectTest
{
    private HealthyObject testItem ;
    private int lifeLevelStart, lifeLevelEnd;
    private Player myPlayer;
    
    /**
     * Default constructor for test class HealthyObjectTest
     */
    public HealthyObjectTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Test
    public void testAction()
    {
        lifeLevelStart = myPlayer.getLifeLevel();
        testItem.action(myPlayer);
        assertEquals(true, lifeLevelStart <= myPlayer.getLifeLevel());
    }

}
