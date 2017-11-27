/**
 * This class manages the NPC with the dialogues.
 *
 * @author  Group 8
 * @version 09/11/17
 */
public class Npc
{
    // instance variables - replace the example below with your own
    public String descriptionNpc;
    public String dialogueNpc;
    

    /**
     * Constructor for objects of class Npc
     */
    public Npc(String descriptionPNJ,String dialoguePNJ)
    {
        // initialise instance variables
        descriptionNpc = descriptionPNJ;
        dialogueNpc = dialoguePNJ;
    }
    
    /**
     * This method return the description of the NPC. The name must have at least 3 and maximum 100. 
     * There is no space before of after the description. 
     *
     * 
     * @return    The description of the NPC
     */
    public String getDescriptionNpc()
    {
        return descriptionNpc;
    }
    
    /**
     * This method return the dialog of the NPC. The name must have at least 3 and maximum 100. 
     * There is no space before of after the dialog. 
     * 
     * @return    The dialog of the NPC
     */
    public String getDialogNpc()
    {
        return dialogueNpc;
    }
    
    /**
     * This method return the dialog of the NPC. The name must have at least 3 and maximum 100. 
     * There is no space before of after the dialog. 
     * 
     * @return    The dialog of the NPC
     */
    public void getDetails()
    {
        System.out.println(descriptionNpc);
        System.out.println(dialogueNpc);
    }
}