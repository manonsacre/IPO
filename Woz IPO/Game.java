import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Random;
import java.lang.*;
import java.util.Scanner;

/**
 * This class is the main class of the "Insane people only" application. It is a very simple, text
 * based adventure game. Users can walk around some scenery. That's all. 
 * This main class manages the global game.
 *
 * @author Group 8
 * @version 09/11/17
 */
public class Game 
{
    // instance variables
    private Player localPlayer;
    private Interface visualInterface;
    private Room currentRoom;
    private Room startRoom, F3Room1, F3Room2, F3Room3, F3Room4, F3Corridor, stairsTo2F;
    private Room F2Room1, F2Room2, F2Room3, F2Room4, F2Room5, F2Corridor, stairsTo1F;
    private Room F1Room1, F1Room2, F1Room3, F1Room4, F1Room5, F1Corridor, stairsToCellar;
    private Room cellar, FinalRoom, mirrorRoom;
    private Npc npcF3Room1, npcF3Room3, npcF2Room1, npcF2Room2, npcF2Room4, npcF1Room5, npcFinalRoom;
    private Monster monsterType3Room2, monsterType3Room3, monsterType2Room5, monsterType2Corridor, monsterType1Room1, monsterType1Room2, monsterType1Corridor, monsterType1Room4, FinalBoss;
    private Item scissors, knife, gun, baseballbat, shovel, littlestone, bone, saucepan, razor, lighter, electricchair, badtorch, pills, rottensandwich, poisonedcupcake, cellphone, water, syringe, aidkit, bandage, cactus, pastries, apple, bluebull;;
    private HealthyObject kit;
    private DamageObject sandw;
    private ArrayList<Item> listItemRoom;
    
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {        
        localPlayer = new Player();
        //listItemRoom = new ArrayList<Item>();
        createRooms();
        printWelcome();
        F3Corridor.printExits();
        Explore();
        currentRoom.fightRoom();
    }

    /**
     * Create all the Npc, this allow to place them in the wanted rooms with their description and their dialog.
     */
    private void createNpc()
    {
        npcF3Room1 = new Npc("There is an old and creepy person in the room.","Hello, I am Georges, I have an advice, there is a cell phone and if you find it you could call someone");
        npcF3Room3 = new Npc("A little girl. It seems that the light is on but nobody is home","Javotte at your service, have a seat");
        npcF2Room1 = new Npc("There is a lady with a up of tea and a funny hat","I'm Ursula can I help you? I made some pastries and cupcake if you want");
        npcF2Room2 = new Npc("A man with odd clothes","I'm Scar and if I was you I would not eat Ursula's pastries");
        npcF2Room4 = new Npc("A man who is lost in his toughs","[Whisper]I'm Frollo, I'm Frollo, I'm Frollo...");
        npcF1Room5 = new Npc("A crazy man with several knives","My name is Freddy Kruger and I will be your worse nightmare");
        npcFinalRoom = new Npc("A horror clown just appeared in the dark","I'm IT and I tell you to go through this door");
    }
    
    /**
     * Create all Items, this allow to place all the different items in the wanted rooms, with their name, their description, 
     * their number of use, the life points they took to the monsters or the life points they give to the player.
     * 
     */
    
    private void createItem()
    {
        scissors = new Weapon ("Scissors", "to scratch the monsters",1,4);
        knife = new Weapon("Knife","to cut the monsters",1,5);
        gun = new Weapon ("Gun","to shot the monsters",1,6);
        baseballbat = new Weapon ("Baseballbat", "to hit the monsters",1,7);
        shovel = new Weapon ("shovel", "to hit the monsters",1,8);
        littlestone = new Weapon ("Little stone", "to throw on the monsters",1,9);
        bone = new Weapon ("Bone", "there is a snag!",1,10);
        saucepan = new Weapon ("Sauce Pan", "you are ready to cook!",1,11);
        
        razor = new DamageObject ("Razor", "oh you cut yourself!",1,4);
        lighter = new DamageObject ("Lighter", "Prince of the flame youre tail is burning",1,5);
        electricchair  = new DamageObject ("Chair", "You should not have sat there, you are electrified. It was in fact an electric chair",1,6);
        badtorch = new DamageObject ("Torch", "It is an old one, it will explode in your hands. Oh sorry, the battery of the torch was oxidized",1,7);
        pills = new DamageObject ("Pills", "Seriously, you take pills like that?? Are you a junkie?",1,8);
        rottensandwich = new DamageObject ("Sandwich", "You will regret to be hungry! because it was rotten",1,9);
        poisonedcupcake = new DamageObject ("Cupcake", "Your gluttony will lost you, the cupcake was poisoned",1,10);
        cellphone = new DamageObject ("Cell Phone ", "You call me on my cellphone!!",1,11);
       
        water = new HealthyObject ("Water", "Just simple water, it is fresh",1,4);
        syringe = new HealthyObject ("Syringe", "Are you really using a syringe in an old asylum? And the hygiene?",1,5);
        aidkit = new HealthyObject ("Aid kit", "Woo it worked! Surprising!",1,6);
        bandage = new HealthyObject ("Bandage", "To treat your wounds",1,7);
        cactus = new HealthyObject ("Cactus", "Oh the juice of the cactus has soothing virtues",1,8);
        pastries  = new HealthyObject ("Pastries", "You are in France so the pastries are obviously good!",1,9);
        apple = new HealthyObject ("Apple", "An apple a day away form the doctor",1,10); 
        bluebull = new HealthyObject ("BlueBull", "It gives you wiiiIIIiings!",1,11);
    }
    
    
    /**
     * Create all the Monster with their name, description and point of life.
     */
    private void createMonster()
    {
        monsterType3Room2 = new Monster("Leatherhead","Crazy man who wants to eat you",35);
        monsterType3Room3 = new Monster("Hannibal Lecter","Crazy man who wants to eat you",35);
        monsterType2Room5 = new Monster("Jigsaw","Crazy man who wants to marry you so he wants to transform you into a woman. So imagine how!",60);
        monsterType2Corridor = new Monster("Fetide","Crazy man who wants to marry you so he wants to transform you into a woman. So imagine how!",60);
        monsterType1Room1 = new Monster("The thing","Crazy woman with several legs all along her body. She looks like a spider and she runs fast",80);
        monsterType1Room2 = new Monster("Annabelle","Crazy woman with several legs all along her body. She looks like a spider and she runs fast",80);
        monsterType1Corridor = new Monster("Mme Voorhees","Crazy woman with several legs all along her body. She looks like a spider and she runs fast",80);
        monsterType1Room4 = new Monster("BloodyMary","Crazy woman with several legs all along her body. She looks like a spider and she runs fast",80);
        FinalBoss = new Monster("CooPoo","There is chimera with several heads, the several projects in Master1 turned us into that creature",100);
    }
    
    
    
    /**
     * Create all the rooms and link their exits together.
     * It allow to attribute each items, monsters and NPC to the wanted rooms.
     */
    private void createRooms()
    {
        createNpc();
        createMonster();
        createItem();
        
        //String nomSalle, String descriSalle, boolean monstrePresent, Monster monstre, ArrayList<Item> objectCache, Npc npc, boolean npcPresent, boolean fouille, boolean ouvert
        
        //3rd Floor room
        startRoom = new Room("Jail", "This is a room of an asylum, you are stuck here.", false, null, null, false, false, false);
        startRoom.addItemRoom(badtorch);
        startRoom.addItemRoom(bandage);
        startRoom.addItemRoom(knife);
        
        // NULL pas recommandé pour LISTE      
        F3Room1 = new Room("Room 1408", "This is a nightmare room", false, null, npcF3Room1, true, false, true);
        F3Room1.addItemRoom(pills);
        F3Room1.addItemRoom(cellphone);
        
        F3Room2 = new Room("Room 13", "This is a slaughterhouse room", true, monsterType3Room2, null, false, false, true);
        F3Room2.addItemRoom(syringe);
        
        F3Room3 = new Room("Eat room", "This is a restaurant room", true, monsterType3Room3, npcF3Room3, true, false, true);
        F3Room3.addItemRoom(scissors);
        
        F3Room4 = new Room("White room", "This is a dazzling room", false, null, null, false, false, true);
        F3Room4.addItemRoom(apple);
        
        F3Corridor = new Room("Mist corridor", "This is a corridor full of fug, you can see nothing", false, null, null, false, false, true);
        stairsTo2F = new Room("Stairs between third floor and second floor", "You can go to the second floor", false, null, null, false, false, true);
        
        
        //2nd Floor room
        F2Room1 = new Room("Dark room", "This is a room where you see nothing, maybe you can use a torch", false, null, npcF2Room1, true, false, true);
        F2Room1.addItemRoom(lighter);
        F2Room1.addItemRoom(pastries);
        F2Room1.addItemRoom(gun);
        
        F2Room2 = new Room("Morgue room", "This is a room full of corpses", false, null, npcF2Room2, true, false, true);
        F2Room2.addItemRoom(rottensandwich);
        F2Room2.addItemRoom(poisonedcupcake);
        F2Room2.addItemRoom(baseballbat);
        
        F2Room3 = new Room("Electrical room", "This is a electrical maintenance room", false, null, null, false, false, true);
        F2Room3.addItemRoom(electricchair);
        
        F2Room4 = new Room("Whisper room", "This is a false silent room ", false, null, npcF2Room4, true, false, true);
        F2Room4.addItemRoom(water);
        F2Room4.addItemRoom(shovel);
        
        F2Room5 = new Room("Running room", "This is a room where you practise sport to save your offspring", true, monsterType2Room5, null, false, false, true);
        F2Room5.addItemRoom(aidkit);
        
        F2Corridor = new Room("Running corridor", "You have to run again", true, monsterType2Corridor, null, false, false, true);
        stairsTo1F = new Room("Stairs between second floor and first floor", "You can go to the first floor", false, null, null, false, false, true);
        
        //1st Floor room
        F1Room1 = new Room("Stone room", "Every little thing is important", true, monsterType1Room1, null, false, false, true);
        F1Room1.addItemRoom(littlestone);
        
        F1Room2 = new Room("Doll room", "I will slith your throat", true, monsterType1Room2, null, false, false, true);
        F1Room2.addItemRoom(razor);
        
        F1Room3 = new Room("Kitchen", "Time to cook!", false, null, null, false, false, true);
        F1Room3.addItemRoom(cactus);
        F1Room3.addItemRoom(saucepan);
        
        F1Room4 = new Room("Red room", "This is a room is full of human blood", true, monsterType1Room4, null, false, false, true);
        F1Room4.addItemRoom(bluebull);
        
        F1Room5 = new Room("Play room", "Do you wanna play a game", false, null, npcF1Room5, true, false, true);
        F1Room5.addItemRoom(bone);
        
        F1Corridor = new Room("Corridor", "Just a creepy corridor", true, monsterType1Corridor, null, false, false, true);
        stairsToCellar = new Room("Stairs between first floor and cellar", "You can go the the cellar", false, null, null, false, false, true);
        
        
        cellar = new Room("Cellar", "This is a bottomless room", false, null, null, false, false, true);
        FinalRoom = new Room("Freedom room", "You will be free... or not", true, FinalBoss, npcFinalRoom, true, false, true);
        mirrorRoom = new Room("Mirror", "This is a reflecting room", false, null, null, false, false, true);
        
        
        //exits of the third floor rooms
        startRoom.setExits(F3Corridor,null,null,null,null,null,null,null);
        F3Room1.setExits(F3Corridor,null,null,null,null,null,null,null);
        F3Room2.setExits(F3Corridor,null,null,null,null,null,null,null);
        F3Room3.setExits(F3Corridor,null,null,null,null,null,null,null);
        F3Room4.setExits(F3Corridor,null,null,null,null,null,null,null);
        F3Corridor.setExits(stairsTo2F,F3Room1,F3Room2,F3Room3,F3Room4,startRoom,null,null);
        stairsTo2F.setExits(F2Corridor,null,null,null,null,F3Corridor,null,null);
        
        //exits of the second floor rooms
        F2Room1.setExits(F2Corridor,null,null,null,null,null,null,null);
        F2Room2.setExits(F2Corridor,null,null,null,null,null,null,null);
        F2Room3.setExits(F2Corridor,null,null,null,null,null,null,null);
        F2Room4.setExits(F2Corridor,null,null,null,null,null,null,null);
        F2Room5.setExits(F2Corridor,null,null,null,null,null,null,null);
        F2Corridor.setExits(stairsTo1F,F2Room5,F2Room2,F2Room3,F2Room4,F2Room1,null,null);
        stairsTo1F.setExits(F1Corridor,null,null,null,null,F2Corridor,null,null);
        
        //exits of the first floor rooms
        F1Room1.setExits(F1Corridor,null,null,null,null,null,null,null);
        F1Room2.setExits(F1Corridor,null,null,null,null,null,null,null);
        F1Room3.setExits(F1Corridor,null,null,null,null,null,null,null);
        F1Room4.setExits(F1Corridor,null,null,null,null,null,null,null);
        F1Room5.setExits(F1Corridor,null,null,null,null,null,null,null);
        F1Corridor.setExits(stairsToCellar,F1Room5,F1Room2,F1Room3,F1Room4,F1Room1,FinalRoom,mirrorRoom);
        stairsToCellar.setExits(cellar,null,null,null,null,F1Corridor,null,null);
        cellar.setExits(stairsToCellar,null,null,null,null,null,null,null);
        
        //currentRoom = startRoom;
        currentRoom = F3Room2;
        
        localPlayer.addItemInventory(knife);
        
    }
    
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        // registerDirections(); // record all the directions in the list 
        

        // // Enter the main command loop.  Here we repeatedly read commands and
        // // execute them until the game is over.
                
        // boolean finished = false;
        // while (! finished) {
            // Command command = parser.getCommand();
            // finished = processCommand(command);
        // }
        // System.out.print('\u000C'); // clear the terminal
        // System.out.println("Thank you for playing.  Good bye.");
        printWelcome();
        localPlayer.checkDeadAndGameOver();
        Explore();
    }
    
    /**
     * Print out the opening message for the player.
     */
    public void printWelcome()
    {
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Welcome in our game ! Insane people only");
        System.out.println("----------------------------------------");
        System.out.println("You are part of the crazy people who wants to play the game :)");
        System.out.println("We want to warm you, this game is difficult and you will want to give up soon.");
    }
    
    /**
     * Print out the opening message for the player.
     */
    public void Explore()
    {
        System.out.println();
        System.out.println("Vous êtes dans " + currentRoom.getRoomName());
        currentRoom.printExits();
        System.out.println("Do you want to explore the room ? ");
        System.out.println("Write yes or no please ");
        Scanner sc = new Scanner(System.in);
        String saisie = sc.nextLine();
        if (saisie != null){ //controler les mots a saisir après
            if (currentRoom.isPresentNpc() == true) {
                System.out.println("the local npc : " + currentRoom.getLocalNpc());
            }
            System.out.println("objets présents dans la pièce : ");
            currentRoom.setDetailsHideObject();
        } else {
            System.out.println("Vous avez choisi de ne pas fouiller la salle");
        }
        // System.out.println("sorties possibles : ");
        // printExits();
    }
    
    /**
     * Method nb, it displays the inventory of the player.
     *
     */
    public void nb()
    {
        localPlayer.affiche();
    }
}
