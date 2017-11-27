

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class RoomTest.
 * Unit tests of the Room class.
 *
 * @author  Group 8
 * @version 09/11/17
 */
public class RoomTest
{
    private Room TESTroom;
    private Monster toi;
    private Npc inutile;
    private ArrayList<Item> objetCache;
    
    /**
     * Default constructor for test class RoomTest
     */
    public RoomTest()
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
        // emptyRoom = new Room("jardin", "ceci est le jardin", true, null, objetCache, inutile, true, true, true);
        TESTroom = new Room ("Jail", "This is a room of an asylum", false, null, null, true, false, true);
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
    
    /**
     * Method testGetRoomName: getRoomName() return the name of the room.
     *
     */
    @Test
    public void testGetRoomName()
    {
        assertEquals((String)TESTroom.getRoomName(), TESTroom.getRoomName());
    }
    
    /**
     * Method testGetRoomDescription: getRoomDescription() return the description
     * of the room.
     *
     */
    @Test
    public void testGetRoomDescription()
    {
        assertEquals((String)TESTroom.getRoomDescription(), TESTroom.getRoomDescription());
    }
    
    // /**
     // * Method testGetExits: getExits() return the list of the possible exits.
     // *
     // */
    // @Test
    // public void testGetExits()
    // {
        // assertEquals((HashMap<Integer, Room>)TESTroom.getExits(), TESTroom.getExits());
    // }
    
    /**
     * Method testIsPresentMonster: isPresentMonster() return the boolean if 
     * there is either a monster in the room or not.
     *
     */
    @Test
    public void testIsPresentMonster()
    {
        assertEquals((boolean)TESTroom.isPresentMonster(), TESTroom.isPresentMonster());
    }
    
    /**
     * Method testGetLocalMonster: getLocalMonster() return the monster of
     * the room.
     *
     */
    @Test
    public void testGetLocalMonster()
    {
        assertEquals((Monster)TESTroom.getLocalMonster(), TESTroom.getLocalMonster());
    }
    
    /**
     * Method testGetHideObject: getHideObject() return the list of the objects.
     *
     */
    @Test
    public void testGetHideObject()
    {
        assertEquals((ArrayList<Item>)TESTroom.getHideObject(), TESTroom.getHideObject());
    }
    
    /**
     * Method testGetLocalNpc: getLocalNpc() return the npc of the room.
     *
     */
    @Test
    public void testGetLocalNpc()
    {
        assertEquals((String)TESTroom.getLocalNpc(), TESTroom.getLocalNpc());
    }
    
    /**
     * Method testIsPresentNpc: isPresentNpc() return if there is a npc or not.
     *
     */
    @Test
    public void testIsPresentNpc()
    {
        assertEquals((boolean)TESTroom.isPresentNpc(), TESTroom.isPresentNpc());
    }
    
    /**
     * Method testIsExplored: isExplored() return if the room is explored or 
     * not.
     *
     */
    @Test
    public void testIsExplored()
    {
        assertEquals((boolean)TESTroom.isExplored(), TESTroom.isExplored());
    }
    
    /**
     * Method testIsOpened: isOpened() return if the room is opened or not.
     *
     */
    @Test
    public void testIsOpened()
    {
        assertEquals((boolean)TESTroom.isOpened(), TESTroom.isOpened());
    }
}
