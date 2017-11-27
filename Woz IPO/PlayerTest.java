
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class PlayerTest.
 * Unit tests of the Player class
 *
 * @author  Group 8
 * @version 09/11/17
 */
public class PlayerTest
{
    private Player myPlayer;
    private Room myRoom;
    private Item myItem;
    private Monster myMonster;
    private Npc myNpc;
    private ArrayList<Item> inventory;
    private int previousLifeLevel;
   
    /**
    * Default constructor for test class PlayerTest
    */
    public PlayerTest()
    {
    }

    /**
    * Sets up the test fixture.
    * <p> Called before every test case method. </p>
      * <p> Initialize one player for each test, whose name is "Frodo" </p>
    */
    @Before
    public void setUp()
    {
        //                      name  lp   as
       myPlayer = new Player();
        
       myRoom = new Room("Salon", "desc", false, myMonster, myNpc, false, false, false);
        
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
    * Method testNameFrodo
    * <p> Checks if the name given as parameter in the constructor is correctly set to the attribute </p>
    */
    @Test
    public void testNameFrodo()
    {
        // The parameter "Frodo" (see setUp) must be set as the name attribute
        assertEquals("Simon", myPlayer.getName());
    }
    
    
    /**
     * method testGetLifeLevel
     * <p> checks if the life level is really an integer
     */
    @Test
    public void testGetLifeLevel(){
        assertEquals(myPlayer.getLifeLevel(), (int)myPlayer.getLifeLevel());
    }
    /**
    * Method testRoom
    * <p> Checks if the name given as parameter in the constructor is correctly set to the attribute </p>
    */
    @Test
    public void testRoom()
    {
        // The parameter "Frodo" (see setUp) must be set as the name attribute
        assertEquals((Room)myPlayer.getLocalisation(), myPlayer.getLocalisation());
    }
    
    /**
     * method test getAttackScore
     */
    @Test
    public void testGetAttackScore(){
        // testing if the returned type is correct
        // assertEquals(true, myPlayer.getAttackScore() == (int)myPlayer.getAttackScore());
        assertEquals(myPlayer.getAttackScore(),(int)myPlayer.getAttackScore());
    }

    /**
    * Method testAdd5LifePoints
    * <P> Checks that 5 life points are really added to the player, resulting in 15 LP </p>
    */
    @Test
    public void testAdd5LifePoints()
    {
        previousLifeLevel = myPlayer.getLifeLevel();
        myPlayer.addLifePoints(5);
        //Assuming the default value is 20, the result is 25 life points
        assertEquals(myPlayer.getLifeLevel(), previousLifeLevel + 5);
    }

    /**
    * Method testNotAddingNegativeLP
    * <p> Checks that adding negative points is not possible </p>
    */
    @Test
    public void testNotAddingNegativeLP()
    {
        previousLifeLevel = myPlayer.getLifeLevel();
        myPlayer.addLifePoints(-5);
        // The number of life points must be unchanged
        assertEquals(previousLifeLevel, myPlayer.getLifeLevel());
    }

    /**
    * Method testLoseLifePointsOk
    * <p> Check that the lose function destroys 5 life points </p>
    */
    @Test
    public void testLoseLifePointsOk()
    {
        previousLifeLevel = myPlayer.getLifeLevel();
        myPlayer.looseLifePoints(5);
        //Assuming the default value is 20, the life points must be 15
        assertEquals(previousLifeLevel, myPlayer.getLifeLevel() + 5);
    }

    /**
    * Method testLoseLifePointsMore
    * <p>Checks that losing more life points than the remaining only sets the life points attribute to 0</p>
    * <p>When life points is set to 0, the player is dead.</p>
    */
    @Test
    public void testLoseLifePointsMore()
    {
        previousLifeLevel = myPlayer.getLifeLevel();
        myPlayer.looseLifePoints(100);
        //Assuming the default value is 20, losing more than 20 points restuls is 0, not negative value
        assertEquals(0, myPlayer.getLifeLevel());
    }
    
    @Test
    // public void deleteItemInventory (Item myItem)
    public void testDeleteItemInventoryPossible(){
        assertEquals(null, inventory); 
    }
    
    
    /**
     * test to check whether deleted item remains or not in the player's inventory
     */
    @Test 
    public void testDeleteItemInventoryEffective(){
        String nameDeletedItem = myItem.getNameObject();
        Boolean found = false;
        myPlayer.deleteItemInventory(myItem);
        for(Item i : inventory) {
            if(nameDeletedItem == i.getNameObject()) {found = true; break;}
        }
        assertEquals(false, found);
    }
        
    
}
