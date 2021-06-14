import java.util.*;

/** 
 * This class implements Cwk 2
 * 
 * @author Manuel Gomes Rosmaninho 
 * @version 09/04/2020
 */
public class ResortUI
{
    //ResortUI Fields
    private Scanner reader = new Scanner(System.in);
    private ResortManager wayward; 
    
    /** Process the choice made and call the correct function
     * 
     */
    public void runUI()
    {   
        wayward = new ResortManager("wayward");
        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllWorlds();}
            else if (choice == 2){listAllCardsbyWorld();}
            else if (choice == 3){listOneWorld();}
            else if (choice == 4){findACard();}
            else if (choice == 5){tryTravel();}
            else if (choice == 6){travelNow();}
            else if (choice == 7){updateCredits();}
            else if (choice == 8){goHome();}
            else if (choice == 9){convertPts();}
            else if (choice == 10){evacuate();}
            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    /** Display a menu of options and get a choice
     * 
     */
    private int getOption()
    {
       System.out.println("What would you like to do ?");
       System.out.println("0. Quit");
       System.out.println("1. List all world details");
       System.out.println("2. List all cards on each worlds");
       System.out.println("3. List all cards on one world");
       System.out.println("4. Find a card");
       System.out.println("5. Say if card can move by shuttle");
       System.out.println("6. Move a card by shuttle");
       System.out.println("7. Top up credits");
       System.out.println("8. Move a card to home world");
       System.out.println("9. Convert points to credits - Business only");
       System.out.println("10. Evacuate all");

       System.out.println("Enter your choice");
       // read choice
       int option = reader.nextInt();
       reader.nextLine();
       return option;
    }
    
    // This one has been done for you 
    /** Returns all of the data about all worlds including the cards
     * currently on each world, or "No cards"
     * @return all of the details of all worlds including  
     * and all cards currently on each world, or "No cards"
     */
    private void listAllWorlds()
    {
        System.out.println(wayward.toString());
    }
    
    // provide the code here  
    /** Returns a String representation of all the cards on all worlds, 
     * listed by world 
     * @return a String representation of all cards on all worlds
     */
    private void listAllCardsbyWorld()
    {
        System.out.println(wayward.getAllCardsOnEachWorld());
    }
   
    // This one has been done for you 
    /** Returns a String representation of all the cards on specified world
     * @return a String representation of all cards on specified world
     */
    private void listOneWorld()
    {
        System.out.println("Enter name of world");
        String ww = reader.nextLine();
        System.out.println(wayward.getAllCardsOnWorld(ww));
    }
    
    // provide the code here
    /** Returns the name of the world which contains the specified card or null
     * @param cr - the specified card
     * @return the name of the World which contains the card, or null
     */
    private void findACard()
    {
        System.out.println("Enter card id");
        int cid = reader.nextInt();
        System.out.println(wayward.findCard(cid));
    }
    
    // This one has been done for you
    /** Returns true if a Card is allowed to move using the shuttle, false otherwise
     * A move can be made if:  
     * the rating of the card  >= the rating of the destination world
     * AND the destination world is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source world
     * AND the card id is for a card on the system
     * AND the shuttle code is the code for a shuttle on the system
     * @param the id of the card requesting the move
     * @param the code of the shuttle journey by which the card wants to pCardel
     * @return true if the card is allowed on the shuttle journey, false otherwise
     */
    private void tryTravel()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter shuttle code");
        String shuttle = reader.nextLine();
        System.out.println(wayward.canTravel(trav,shuttle));
    }
    
    // provide the code here
    /** Returns the result of a card requesting to move by Shuttle.
     * A move will be successful if:  
     * the luxury rating of the card  >= the luxury rating of the destination world
     * AND the destination world is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source world
     * AND the card id is for a card on the system
     * AND the shuttle code is the code for a shuttle on the system
     * If the shuttle journey can be made, the card information is removed from the source
     * world, added to the destination world and a suitable message returned.
     * If shuttle journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param the id of the card requesting the move
     * @param the code of the shuttle journey by which the card wants to pCardel
     * @return a String giving the result of the request
     */
    private void travelNow()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter shuttle code");
        String shuttle = reader.nextLine();
        System.out.println(wayward.travel(trav,shuttle));
    }
    
    // provide the code here if you have done Task 7
    /** Allows a card to top up their credits.This method is not concerned with 
     *  the cost of a credit as currency and prices may vary between resorts.
     *  @param the id of the card toping up their credits
     *  @param the number of credits purchased to be added to cards information
     */
    private void updateCredits()
    {
        System.out.println("Enter card id");
        int cid = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter number of credits");
        int cred = reader.nextInt();
        wayward.topUpCredits(cid,cred);
        System.out.println("Added " + cred + 
                           " credits for card number " + cid + "\n");
    }
    
    // provide the code here
    /** Moves a card directly back to the home world without affecting credits
     *  and not using existing shuttles
     *  @param the id of the card to move back Home
     */
    private void goHome()
    {
        System.out.println("Enter card id");
        int cid = reader.nextInt();
        wayward.moveHome(cid);
        System.out.println("Card number " + cid + " moved to Home World\n");
    }
    
    // provide the code here
    /** Converts a card's loyalty points into credits
     * @param the id of the card whose points are to be converted
     */
    private void convertPts()
    {
        System.out.println("Enter card id");
        int cid = reader.nextInt();
        wayward.convertPoints(cid);
        System.out.println("Points converted for card number " + cid + "\n");
    }
    
    // provide the code here
    /** In an emergency, evacuates all cards directly back to the home world without 
     * affecting credits or other information and not using existing shuttles
     */
    private void evacuate()
    {
        wayward.evacuateAll();
        System.out.println("All Cards moved back to the Home World\n");
    }
}
