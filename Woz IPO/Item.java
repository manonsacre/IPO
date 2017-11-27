import java.util.*;
import java.lang.*;
/**
 * Item is an object that it could be used and store by the player. 
 * There are some types of objects. You have to use it as you want 
 * with any risks or not...
 *
 * @author Group 8
 * @version 09/11/2017
 */

 public abstract class Item
{
    // instance variables 
    private String nameObject;
    private String descriptionObject;
    private int pointsObject; // value of the item like gain of life or attack point for weapon
    private int nbUtilisation; // number of use of the object
    private boolean invisible;
    
    
    /**
     * Constructor for objects of class Item
     */
    public Item (String nameObj, String des, int u)
    {
       nameObject = nameObj;
       descriptionObject = des;
       nbUtilisation = u;
       invisible = false;
    }

    /**
     * Displays the name of the object
     *
     * @return nameObject,   the name of the object
     */
     public String getNameObject()
     {
         return nameObject;
      }
      
    /**
     * Displays the description of the object
     *
     * @return  descriptionObject,  the description of the object
     */
     public String getDescriptionObject()
     {
         return descriptionObject;
      }
    
    /**
     * Displays the number of use of the object
     *
     * @return nbUtilisation   the number of utilisation of the object
     */
     public int getNbUtilisation()
     {
         return nbUtilisation;
      }  
    
    /**
     * Displays the value of object power
     * 
     * @return pointsObject,   the value of object power
     */
     public int getPointsObject()
     {
         return pointsObject;
      } 
      
    /**
     * Displays the number of use of the object
     *
     * @return nbUtilisation   the number of utilisation of the object
     */
     public void setNbUtilisation()
     {
         nbUtilisation = nbUtilisation -1;
        
      }  
           
     /**
      * Method that return in terminal
      * 
      */       
     public void printDetails()
     {    
          System.out.println("*****************Item***********");
          System.out.println(nameObject);
          System.out.println(descriptionObject);
          System.out.println(pointsObject);
          System.out.println(nbUtilisation); 
          System.out.println("****************************");
        }
        
    /**
    * Action of the Item
    * 
    */
    abstract public void action(Player myPlayer);
    
}
