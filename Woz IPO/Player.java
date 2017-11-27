import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Random;

/**
 * This class manages the player with characteristics
 *
 * @author Group 8
 * @version 09/11/17
 */
public class Player
{
    // instance variables - replace the example below with your own
    private String name;
    private ArrayList<Item> inventory;
    private int lifeLevel;
    private Room localisation;
    private int attackScore;
    private boolean dead;
 
    

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
        name = "Simon";
        lifeLevel = calculLifeLevel(); 
        attackScore = calculAttackScore();
        inventory = new ArrayList <Item> ();
        dead = false;
    }
    
    /**
     * Method to do the calculation of a 
     * @return a, integer = life level
     */
    public int calculLifeLevel(){
        int a =20+(int)(Math.random()*((50-20)+1));
        return a;
    }
    
    /**
     * Method to do the calculation of b 
     * @return b, integer = score of the player
     */
    public int calculAttackScore(){
        int b =10+(int)(Math.random()*((30-10)+1));
        return b;
    }
    
    /**
     * get attackScore
     * @return attackScore, integer = score of the player
     */
    public int getAttackScore(){
        return attackScore;
    }
    
    /**
     * getName - display the name of the player
     *
     * @return    the name of the player
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method to add an Item in the inventory of the player
     * 
     *@param Item It is the Item which added in the inventory
     */
    public void addItemInventory(Item myItem)
    {
        boolean allowAdding= true;
        
        if (inventory.size() > 0)
        {
            for (Item i : inventory)
            {
                if (myItem.getNameObject() == i.getNameObject())
                {
                    allowAdding = false;
                }
            }
        }
        
        if (allowAdding == true)
        {
            inventory.add(myItem);
        }
        
    }
    
    /** 
     * Delete an Item of the inventory
     * 
     * @param Item is the Item which is delete
    */
    public void deleteItemInventory (Item myItem)
    {
        if (inventory.size() >0) {
            for (int i = 0; i < inventory.size(); i++) {
                if (myItem.getNameObject() == inventory.get(i).getNameObject() && inventory.get(i).getNbUtilisation()==0){
                    inventory.remove(i); 
                }     
            }
        }
    }
        
    /**
     * getInventory - display the inventory of the player
     *
     * @return    the inventory of the player
     */
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }
    
    /**
     * getName - display the name of the player
     *
     * @return    the name of the player
     */
    public int getLifeLevel()
    {
        return lifeLevel;
    }
    
    /**
     * getName - display the name of the player
     *
     * @return    the name of the player
     */
    public Room getLocalisation()
    {
        return localisation;
    } 
    
    /**
     * isDead - display the status of the player
     *
     * @return    if the player is dead
     */
    public boolean isDead()
    {
        return dead;
    }
        
    /**
     * Add 5 points life
     *
     * @param    int n
     * @return    the name of the player
     */
    public void addLifePoints(int nHealthy)
    {
       lifeLevel = lifeLevel + nHealthy;
    }
    
    /**
     * Lose 5 points life
     *
     * @param    int n
     * @return    the name of the player
     */
    public void looseLifePoints(int nDamage)
    {
        lifeLevel = lifeLevel - nDamage;
    }
    
    /**
     * Add Attack points from the weapon
     *
     * @param    int n
     * @return    the name of the player
     */
    public void addAttackPoint(int nWeapon)
    {
        attackScore = attackScore + nWeapon;
    }
    
    /**
     * Suppress the Attack points from the weapon when the weapon is totally used
     *
     * @param    int n
     * @return    the name of the player
     */
    public void looseAttackPoint(int nWeapon)
    {
        attackScore = attackScore - nWeapon;
    }
    
    /**
     * Print the details of the player inventory
     * 
     */
    
    public void affiche () 
    {
        for (int i = 0; i < inventory.size(); i++) 
        {
            inventory.get(i).printDetails();        
        }
    }
    
    /**
     * setDead() - if the life level is 0, the player is dead.
     *
     */
    public void checkDeadAndGameOver()
    {
        if (lifeLevel == 0){
            dead = true;
        }
        
        if (isDead() == true){
            System.out.println("GAME OVER");
            System.out.println("You are dead. Try again ;) ");
            //qqch pour quitter
        } else {
            System.out.println("Congratulations, You are alive ! ");
            System.out.println("But don't be sure it is a good thing");
        }
    }
}
