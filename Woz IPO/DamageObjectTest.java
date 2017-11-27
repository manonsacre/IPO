import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DamageObjectTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DamageObjectTest
{
    private DamageObject testItem;
    
    /**
     * Default constructor for test class DamageObjectTest
     */
    public DamageObjectTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
    
    /**
     * test of the points
     */
    @Test
    public void testGetPointsHealthy()
    {
        assertEquals(true, testItem.getPointsDamage() > 3 && testItem.getPointsDamage()< 12);
    }
}
