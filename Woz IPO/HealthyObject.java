import java.util.*;
import java.lang.*;
/**
 * Item is an object that it could be used and store by the player. 
 * These objects are healer to help the player.
 * 
 * @author Group 8
 * @version 09/11/17
 */
public class HealthyObject extends Item
{
    // variables d'instance
    private int pointsHealthy;

    /**
     * Constructor for objects of the class HealthyObject
     */
    public HealthyObject(String name, String des, int u, int p)
    
    {
        // initialisation des variables d'instance
        super(name, des, u);
        pointsHealthy = p;
    }  
    
    /**
     * Displays the value of object power
     * 
     * @return pointsHealthy,   the value of object power
     */
     public int getPointsHealthy()
     {
         return pointsHealthy;
      } 
    
    /**
     * Add life point to the player
     * 
     * @ param myPlayer the player who plays
     */
    public void action(Player myPlayer)
    {
       if (getNbUtilisation() == 0) {
           System.out.println("Not possible");
       } else {
           int nHealthy = getPointsHealthy();
           myPlayer.addLifePoints(nHealthy);

       }
    }
}
