import java.util.*;
import java.lang.*;

/**
 * Room is a room on the map of the game. There are possible exits of this room. There 
 * can be a monster or objects in a room. You have to explore it.
 *
 * @author Group 8
 * @version 09/11/17
 */
public class Room
{
    private String roomName;
    private String roomDescription;
    private HashMap<String, Room> exits;
    private boolean presentMonster;
    private Monster localMonster;
    private ArrayList<Item> hideObject;
    private Npc localNpc;
    private boolean presentNpc;
    private boolean explored;
    private boolean open;
    private Item myItem;
    private Player localPlayer;
    

    /**
     * Constructor for objects of class Room
     */
    public Room(String nomSalle, String descriSalle, boolean monstrePresent,Monster monstre, Npc npc, boolean npcPresent, boolean fouille, boolean ouvert)
    {
        // initialise instance variables
        roomName = nomSalle;
        roomDescription = descriSalle;
        exits = new HashMap<String, Room>();
        presentMonster = monstrePresent;
        localMonster = monstre; 
        hideObject = new ArrayList <Item>();
        localNpc = npc;
        presentNpc = npcPresent;
        explored = fouille;
        open = ouvert;
        
        
    }

    /**
     * getRoomName - display the name of the room
     *
     * @return    string --> name of the room
     */
    public String getRoomName()
    {
        return roomName;
    }
    
    /**
     * getRoomDescription - display the descritpion of the room
     *
     * @return    string --> description of the room
     */
    public String getRoomDescription()
    {
        return roomDescription;
    }
    
    /**
     * Method nb, it displays the inventory of the player.
     *
     */
    public void printExits()
    {
        System.out.println("liste des sorties possibles : ");
        Iterator<Room> it = exits.values().iterator();
        while(it.hasNext()){
            System.out.println(it.next().getRoomName());
        }
    }
    
    /**
     * isPresentMonster - display if a monster is present or not in the room
     *
     * @return    boolean --> the status of the prensence of a monster
     */
    public boolean isPresentMonster()
    {
        return presentMonster;
    }
    
    /**
     * getLocalMonster - display the monster of the room
     *
     * @return    monster --> the monster of the room
     */
    public Monster getLocalMonster()
    {
        return localMonster;
    }
    
    /**
     * getHideObject - display the hide objects of the room
     *
     * @return    object --> the monster of the room
     */
    public ArrayList<Item> getHideObject()
    {
        return hideObject;
    }
    
    
    /**
     * setDetailsHideObject 
     * 
     */
    public void setDetailsHideObject()
    {
        for(int i = 0; i < hideObject.size(); i++) {
            hideObject.get(i).printDetails();
        }
    }
    
    /**
     * getLocalNpc - display the npc of the room
     *
     * @return    String --> the npc description of the room
     */
    public String getLocalNpc()
    {
        return localNpc.getDescriptionNpc();
    }
    
    /**
     * getLocalNpcDialog - display the npc dialog of the room
     *
     * @return    String --> the npc dialog of the room
     */
    public String getLocalNpcDialog()
    {
        return localNpc.getDialogNpc();
    }
    
    /**
     * getPresentNpc - display if a npc is present in the room
     *
     * @return    boolean --> presence of a npc or not
     */
    public boolean isPresentNpc()
    {
        return presentNpc;
    }
    
    /**
     * isExplored - display if the room is explored 
     *
     * @return    boolean --> room explored or not
     */
    public boolean isExplored()
    {
        return explored;
    }
    
    /**
     * isOpened - display if the room is opened 
     *
     * @return    boolean --> room opened or not
     */
    public boolean isOpened()
    {
        return open;
    }
        
    /**
     * setExits - enter the possible exits of the room
     *
     * @param     Room r 
     */
    public void setExits(Room devant, Room droite1, Room gauche1, Room gauche2, Room droite2, Room derriere, Room sortieF1, Room sortieF2)
    {
        if (devant != null)
            exits.put("ahead",devant);
        if (droite1 != null)
            exits.put("right1",droite1);
        if (gauche1 != null)
            exits.put("left1",gauche1);
        if (gauche2 != null)
            exits.put("left2",gauche2);
        if (droite2 != null)
            exits.put("right2",droite2);
        if (derriere != null)
            exits.put("behind",derriere);
        if (sortieF1 != null)
            exits.put("final exits 1",sortieF1);
        if (sortieF2 != null)
            exits.put("final exits 2",sortieF2);
    }
    
    /**
     * Add an Item in a room
     * @param  myItem : the item which could be added in the room
     */
    
    public void addItemRoom (Item myItem)
    {
        String chooseName = myItem.getNameObject();
         boolean exist = false;
        
        for (Item it : hideObject)
        {
            if (it.getNameObject().equals(chooseName))
            {
                exist= true;
            }
        }
        
        if (exist == false)
        {
            hideObject.add(myItem);
        }
    }
   
    /**
     * Method to manage the consequences of the fight between the player and a monster
     * 
     */
    public void fightRoom()
    {
        int nbplayer ;
        int nbmonstre;
        int p = 0+(int)(Math.random()*((10-0)+1));
        myItem.action(localPlayer);
        nbplayer = localPlayer.getLifeLevel() + localPlayer.getAttackScore();
        nbmonstre = localMonster.getPowerMonster();
        
        if (nbplayer >= nbmonstre) {
            localMonster.setMonsterDead();//mort du monstre
            localMonster.switchMonsterVisibility();//Monstre devient invisible
            localPlayer.looseLifePoints(p);//Perte des points de vie.
            localPlayer.deleteItemInventory(myItem);//Suppression de l'arme de l'inventaire
        } else {
            localPlayer.looseLifePoints(10);
            
        }
    }
}
