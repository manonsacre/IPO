
/**
 * This class manages the monster with their power.
 *
 * @author Group 8
 * @version 09/11/17
 */
public class Monster
{
    // instance variables - replace the example below with your own
    private String nameMonster;
    private String descriptionMonster;
    private int powerMonster;
    private boolean hidden;
    private boolean dead;
    
    /**
     * Constructor for objects of class Monster
     */
    // public Monster(String nameMonsterX, String descriptionMonsterX, boolean visibility, boolean living)
    // public Monster(String name, String desc, int power, boolean a, boolean b)
    public Monster(String nameMonsterX, String descriptionMonsterX, int powerMonsterX){
        // initialise instance variables
        this.nameMonster = nameMonsterX; 
        this.descriptionMonster = descriptionMonsterX;
        this.powerMonster = powerMonsterX;
        this.hidden = false;
        this.dead = false;
    }
    
    /**
     * Method manages the monster dies
     */
    public void setMonsterDead(){
        this.dead = true;
    }
    
    /**
     * Method manages the monster change status (hidden -> visible)
     */
    public void switchMonsterVisibility(){
        if (!this.dead) this.hidden = !hidden;        
    }
    
    /**
     * Method to get monster status
     * 
     * @return boolean
     */
    public boolean getMonsterVisibility(){
        return (!hidden);
    }
    
    /**
     * Method to get monster name
     * @return String
     */
    public String getMonsterName(){
        return nameMonster;
    }
    
    /**
     * Method to get monster name
     * @return String
     */
    public int getPowerMonster(){
        return powerMonster;
    }
    
    /**
     * Method to get monster description
     * @return String
     */
    public String getMonsterDescription(){
        return descriptionMonster;
    }
    
    /**
     * Method which used to know if the monster is still active or already killed
     * @return boolean
     */
    public boolean getMonsterStatus(){
        return dead;
    }
}
