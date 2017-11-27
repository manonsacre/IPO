import java.util.*;
import java.lang.*;

/**
 * Item is an object that it could be used and store by the player. 
 * These objects are weapons to kill a monster.
 *
 * @author Group 8
 * @version 09/11/17
 */

public class Weapon extends Item
{
    // instances variables
    private int pointsWeapon;
    
    /**
     * Constructor for objects of the class Weapon
     */
    public Weapon(String name, String des, int p, int u)
    {
        super(name, des, u);
        pointsWeapon = p;

    }
    
    /**
     * Displays the value of object power
     * 
     * @return pointsWeapon,   the value of object power
     */
     public int getPointsWeapon()
     {
         return pointsWeapon;
     } 
     
    /**
     * Add life point to the player
     * 
     * @param myPlayer the player who plays
     * 
     */
    public void action(Player myPlayer)
    {
       int nWeapon = getPointsObject();
       
        if (getNbUtilisation() == 0) {
           System.out.println("Not possible");
           myPlayer.looseAttackPoint(nWeapon);
       } else {
           
           myPlayer.addAttackPoint(nWeapon);
           setNbUtilisation();           
       }
    }
}
