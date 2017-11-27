import java.util.*;
import java.lang.*;

/**
 * It is an object that it could be used and store by the player. 
 * These objects are traps for the player.
 *
 * @author Group 8
 * @version 09/11/17
 */
public class DamageObject extends Item
{
    // instance variables 
    private ArrayList<Item> obj;
    private int pointsDamage;
    
    /**
     * Constructor for objects of class DamageObject
     */
    public DamageObject(String name, String des, int u, int p)
    {
        super(name, des, u);
        pointsDamage = p;
    }
    
    /**
     * Displays the value of object power
     * 
     * @return pointsDamage,   the value of object power
     */
     public int getPointsDamage()
     {
         return pointsDamage;
     } 
     
    /**
     * Subtract life point to the player
     * 
     * @param myPlayer the player who plays
     */
    public void action(Player myPlayer)
    {
       if (getNbUtilisation() == 0) {
        System.out.println("Not possible");
    } else {
       int nDamage = getPointsDamage();
       myPlayer.looseLifePoints(nDamage); 
       
       setNbUtilisation();

    }
    }
}
