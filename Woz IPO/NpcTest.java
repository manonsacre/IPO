
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NpcTest.
 *
 * @author  Group 8
 * @version 09/11/17
 */
public class NpcTest
{
    private Npc personnage;
    
    /**
     * Default constructor for test class NpcTest
     */
    public NpcTest()
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
        personnage = new Npc("descriptionTEST","dialogueTEST");
    }
    
    /**
     * Sets up the test fixture.
     *
     * Test of the length of the description 
     */
    @Test
    public void testLengthDescriptionMaximum()
    {
        assertEquals(true,(personnage.getDescriptionNpc()).length() <=100);
    }
    
    /**
     * Sets up the test fixture.
     *
     * Test of the length of the description 
     */
    @Test
    public void testLengthDescriptionMinimum()
    {
        assertEquals(true,(personnage.getDescriptionNpc()).length() >=3);
    }
    
    /**
     * Sets up the test fixture.
     *
     * Test of the length of the dialog of the npc 
     */
    @Test
    public void testLengthDialogMinimum()
    {
        assertEquals(true,(personnage.getDialogNpc()).length() >=3);
    }
    
    /**
     * Sets up the test fixture.
     *
     * Test of the length of the dialog of the npc 
     */
    @Test
    public void testLengthDialogMaximum()
    {
        assertEquals(true,(personnage.getDialogNpc()).length() <=100);
    }
    
    /**
     * Sets up the test fixture.
     *
     * Test of the get of the description
     */
    @Test
    public void testGetDescriptionNPC()
    {
      assertEquals((String)personnage.getDescriptionNpc(),personnage.getDescriptionNpc());
    }
    
    /**
     * Sets up the test fixture.
     *
     * Test of the get of the dialog of the npc
     */
    @Test
    public void testGetDialogNPC()
    {
      assertEquals((String)personnage.getDialogNpc(),personnage.getDialogNpc());
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}