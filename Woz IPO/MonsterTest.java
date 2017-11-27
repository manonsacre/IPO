

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MonsterTest.
 *
 * @author  Group 8
 * @version 09/11/17
 */
public class MonsterTest
{
    private Monster targetMonster;
    private boolean booleanTest;
    
    /**
     * Default constructor for test class MonsterTest
     */
    public MonsterTest()
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
        targetMonster = new Monster ("testMonsterName", "testMonsterDescription", 0);
    }

    
    /**
     * test status of monster
     * test name of monster
     * test of description of monster
     * test visibility of monster (caché ou non)
     */
    @Test
    public void testingMonsterStatus(){
        booleanTest = targetMonster.getMonsterStatus();
        targetMonster.setMonsterDead();
        assertEquals(!booleanTest, targetMonster.getMonsterStatus());
    }
    
    /**
     * test status of monster
     * checks if the name of the monster is a string type
     */
    @Test
    public void testingMonsterName(){
        assertEquals((String)targetMonster.getMonsterName(), targetMonster.getMonsterName());
    }

    /**
     * test description of monster
     * checks if the description of the monster is a string type
     */
    @Test
    public void testMonsterDescription(){
        assertEquals((String)targetMonster.getMonsterDescription(), targetMonster.getMonsterDescription());
    }

    /**
     * test visibility of monster
     */
    @Test
    public void testMonsterVisibility(){
        booleanTest = targetMonster.getMonsterVisibility();
        targetMonster.switchMonsterVisibility();
        assertEquals(!booleanTest, targetMonster.getMonsterVisibility());
    }
    
    /**
     * test get powerMonster
     */
    @Test
    public void testGetPowerMonster(){
        assertEquals(true, targetMonster.getPowerMonster() >= 0);
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
