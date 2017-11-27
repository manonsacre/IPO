import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * The test class ItemTest.
 * Unit tests of the Item class
 *
 * @author  Group 8
 * @version 09/11/2017
 *
 */
public class ItemTest
{
    private Item myItem;
    /**
     * Constructor of the Item class test.
     */
    public ItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Initialize one object for the test
     */
    @Before
    public void setUp() 
    {
        // Initialisez ici vos engagements
       // myItem= new Item ("Sandwich", "Tue", 3, 5);
    }
    
    /**
    * Tears down the test fixture.
    * <p> Called after every test case method. Nothing to do in this case </p>
    */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Method testGetNameObject: getNameObject() return the name of the item.
     *
     */
    @Test
    public void testGetNameObject()
    {
        assertEquals("Sandwich", myItem.getNameObject());
    }
    
    /**
     * Method testGetItemDescription: getItemDescription() return the description of the item.
     *
     */
    @Test
    public void testGetItemDescription()
    {
        assertEquals("Tue", myItem.getDescriptionObject());
    }
    
    /**
     * Method testGetNbUtilisation(): getNbUtilisation return the number of the utilisation of the item.
     *
     */
    @Test
    public void testGetNbUtilisation()
    {
        assertEquals(3, myItem.getNbUtilisation());
    }

    
    /**
     * Method testSoustraction(): check the subtracted used return 
     * the NbUtilisation
     *
     */
    @Test
    public void testSoustraction() 
    {
      int c;
      c=myItem.getNbUtilisation();
      //myItem.useIt();
      
      assertEquals(c-1,myItem.getNbUtilisation()); 
    }
}
