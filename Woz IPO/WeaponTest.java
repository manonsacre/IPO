

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WeaponTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WeaponTest
{
    private Weapon testItem;
    
    /**
     * Default constructor for test class WeaponTest
     */
    public WeaponTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Test
    public void testGetPointsWeapon()
    {
        assertEquals(true, testItem.getPointsWeapon() > 3 && testItem.getPointsWeapon()< 12);
    }
}
