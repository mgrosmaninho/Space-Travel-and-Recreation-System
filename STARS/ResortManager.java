import java.util.*;

/**
 * This class implements Cwk 2
 *
 * @author A.A.Marczyk 
 * @version 09/02/20
 **/
public class ResortManager 
{
    //ResortManager Fields
    private ArrayList<Card> allCards = new ArrayList<Card>();
    private ArrayList<World> allWorlds = new ArrayList<World>();
    private ArrayList<Shuttle> allShuttles = new ArrayList<Shuttle>();
    private String name;
    
    /** Creates a ResortManager
     * @param nme represents the ResortManager's name
     */
    public ResortManager(String nme)
    {
        name = nme;
        loadCards();
        loadWorlds();
        setUpShuttles();
        moveCardsToHome();
    }
    
    /** Returns all of the data about all worlds including the cards
     * currently on each world, or "No cards"
     * @return all of the details of all worlds including  
     * and all cards currently on each world, or "No cards" 
     */
    public String toString()
    {
        String ss = "";
        for (World temp : allWorlds)
        {
            ss = ss + "\n\n" + temp.toString();
        }
        return ss;
    }

    /** Returns a String representation of all the cards on all worlds, 
     * listed by world 
     * @return a String representation of all cards on all worlds
     **/
    public String getAllCardsOnEachWorld()
    {
        String ss = "";
        for (World temp : allWorlds)
        {
            ss = ss + "\nWorld: " + temp.getName() +
                      "\n***CardList***" + temp.getCardList() +
                      "\n";
        }
        return ss;
    }
    
    /** Returns the name of the world which contains the specified card or null
     * @param cr - the specified card
     * @return the name of the World which contains the card, or null
     **/
    public String findCard(int cr)
    {
        for (World temp : allWorlds)
        {
            if (temp.isOnList(cr))
            {
                return "\nThe card no " + cr +
                        " is at " + temp.getName() +
                        " World\n\n";
            }
        }       
        return "null";
    }
    
    /** Given the name of a world, returns the world id number
     * or -1 if world does not exist
     * @param ww of world
     * @return id number of world
     */
    public int getWorldNumber(String ww)
    {
        for (World temp : allWorlds)
        {
            if (temp.getName().equals(ww))
            {
                return temp.getWorldNo();
            }
        }
        return -1;
    }
    
    /** Returns a String representation of all the cards on specified world
     * @return a String representation of all cards on specified world
     **/
    public String getAllCardsOnWorld(String world)
    {
        for (World temp : allWorlds)
        {
            if (temp.getName().equals(world))
            {
                return "" + temp.getCardList();
            }
        }
        return "This World does not exist";
    }
    
    /** Returns true if a Card is allowed to move using the shuttle, false otherwise
     * A move can be made if:  
     * the rating of the card  >= the rating of the destination world
     * AND the destination world is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source world
     * AND the card id is for a card on the system
     * AND the shuttle code is the code for a shuttle on the system
     * @param crId is the id of the card requesting the move
     * @param shtlCode is the code of the shuttle journey by which the card wants to pCardel
     * @return true if the card is allowed on the shuttle journey, false otherwise 
     **/
    public boolean canTravel(int crId, String shtlCode)
    {
        Card c = getCard(crId);
        Shuttle s = getShuttle(shtlCode);
        s.addCardToTravel(c);
        return s.canTravel();
    }
    
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
     * @param pCardId is the id of the card requesting the move
     * @param shtlCode is the code of the shuttle journey by which the card wants to pCardel
     * @return a String giving the result of the request 
     **/
    public String travel(int pCardId, String shtlCode)
    {
        Card c = getCard(pCardId);
        Shuttle s = getShuttle(shtlCode);
        s.addCardToTravel(c);
        if (s.testLuxuryRating())
        {
            if (s.testCapacity())
            {
                if (s.testCredits())
                {
                    if (s.testLocation())
                    {
                        return s.travel();
                    }
                    return "You are not in the correct World\n";
                }
                return "You don't have enough credits\n";
            }
            return "The World destination is full\n";
        }
        return "You don't have the luxury rating of the destination World\n";
    }
    
    /** Add routes to ALL Shuttles in the initialization of the system
     * 
     */
    private void addRoutesToShuttle(String sNa, String sW, String dW)
    {
        Shuttle temp = getShuttle(sNa);
        World s = getWorld(sW);
        temp.addWorldSource(s);
        World d = getWorld(dW);
        temp.addWorldDestination(d);
    } 
    
    /** Move ALL Cards to Home in the initialization of the system
     * 
     */
    private void moveCardsToHome()
    {
        for (Card ctemp : allCards)
        {
            World wtemp = allWorlds.get(0);
            wtemp.enter(ctemp);
        }
    }
    
    /** Returns a list of Cards
     * @return list of Cards
     */
    public String getAllCards()
    {
        String ss = "";
        // call ArrayList method
        for (Card temp : allCards) {
            ss = ss + "\n" + temp.toString();  // call Card method
        }
        return ss;
    }
    
    /** Returns a list of Worlds
     * @return list of Worlds
     */
    public String getAllWorlds()
    {
        String ss = "";
        // call ArrayList method
        for (World temp : allWorlds) {
            ss = ss + "\n" + temp.toString();  // call World method
        }
        return ss;
    }
    
    /** Returns a list of Shuttles
     * @return list of Shuttles
     */
    public String getAllShuttles()
    {
        String ss = "";
        // call ArrayList method
        for (Shuttle temp : allShuttles) {
            ss = ss + "\n" + temp.toString();  // call Shuttle method
        }
        return ss;
    }
    
    // These methods are for Task 6 only and not required for the Demonstration 
    // If you choose to implement them, uncomment the following code    
    /** Allows a card to top up their credits.This method is not concerned with 
     *  the cost of a credit as currency and prices may vary between resorts.
     *  @param id the id of the card toping up their credits
     *  @param creds the number of credits purchased to be added to cards information
     */
    public void topUpCredits(int id, int creds)
    {
        Card c = getCard(id);
        c.insertCredit(creds);
    }
    
    /** Moves a card directly back to the home world without affecting credits
     *  and not using existing shuttles
     *  @param enter the id of the card to move back Home
     */
    public void moveHome(int id)
    {
        for (World temp : allWorlds)
        {
            if (temp.isOnList(id) && temp.getWorldNo() != 0)
            {
                temp.leave(id);
                World wtemp = allWorlds.get(0);
                Card c = getCard(id);
                wtemp.enter(c);
            }
        }       
    }
  
    /** Converts a card's loyalty points into credits
     * @param enter the id of the card whose points are to be converted
     */
    public void convertPoints(int id)
    {
        Card c = getCard(id);
        c.convertLoyaltyToCredit();
    }
    
    /** In an emergency, evacuates all cards directly back to the home world without 
     * affecting credits or other information and not using existing shuttles
     */
    public void evacuateAll()
    {
        for (Card ctemp : allCards)
        {
            for (World wtemp : allWorlds)
            {
                int cid = ctemp.getCardNo();
                if (wtemp.isOnList(cid) && wtemp.getWorldNo() != 0)
                {
                    wtemp.leave(cid);
                    World temp = allWorlds.get(0);
                    temp.enter(ctemp);
                }
            }
        }
    }
    
    //***************private methods**************
    // create all cards in Appendix A and add them to their collection
    private void loadCards()
    {
        //call Card constructor
        Card c1 = new Card(1000, "Lynn", 5, 10);
        Card c2 = new Card(1001, "May", 3, 30);
        Card c3 = new Card(1002, "Nils", 10, 25);
        Card c4 = new Card(1003, "Olek", 2, 12);
        Card c5 = new Card(1004, "Pan", 3, 3);
        Card c6 = new Card(1005, "Quin", 1, 30);
        Card c7 = new Card(1006, "Raj", 10, 6);
        Card c8 = new Card(1007, "Sol", 7, 20);
        Card c9 = new Card(1008, "Tel", 6, 30);
        
        //add new cards into the Array
        allCards.add(0, c1);
        allCards.add(c2);
        allCards.add(c3);
        allCards.add(c4);
        allCards.add(c5);
        allCards.add(c6);
        allCards.add(c7);
        allCards.add(c8);
        allCards.add(c9);
    }
    
    // create all worlds in Appendix A and add them to their collection
    private void loadWorlds()
    {
        //call World constructor
        World w1 = new World(0, "Home", 0, 1000);
        World w2 = new World(1, "Sprite", 1, 100);
        World w3 = new World(2, "Tropicana", 3, 10);
        World w4 = new World(3, "Fantasia", 5, 2);
        World w5 = new World(4, "Solo", 1, 1);
        
        //add new worlds into the Array
        allWorlds.add(w1);
        allWorlds.add(w2);
        allWorlds.add(w3);
        allWorlds.add(w4);
        allWorlds.add(w5);
    }
    
    // create all shuttles in Appendix A and add them to their collection
    private void setUpShuttles()
    {
        //call Shuttle constructor
        Shuttle s1 = new Shuttle("ABC1");
        Shuttle s2 = new Shuttle("BCD2");
        Shuttle s3 = new Shuttle("CDE3");
        Shuttle s4 = new Shuttle("DEF4");
        Shuttle s5 = new Shuttle("EFG5");
        Shuttle s6 = new Shuttle("GHJ6");
        Shuttle s7 = new Shuttle("HJK7");
        Shuttle s8 = new Shuttle("JKL8");
        
        //add new shuttles into the Array
        allShuttles.add(s1);
        allShuttles.add(s2);
        allShuttles.add(s3);
        allShuttles.add(s4);
        allShuttles.add(s5);
        allShuttles.add(s6);
        allShuttles.add(s7);
        allShuttles.add(s8);
        
        //add routes to shuttles
        addRoutesToShuttle("ABC1", "Home", "Sprite");
        addRoutesToShuttle("BCD2", "Sprite", "Home");
        addRoutesToShuttle("CDE3", "Sprite", "Tropicana");
        addRoutesToShuttle("DEF4", "Tropicana", "Sprite");
        addRoutesToShuttle("EFG5", "Fantasia", "Sprite");
        addRoutesToShuttle("GHJ6", "Sprite", "Solo");
        addRoutesToShuttle("HJK7", "Solo", "Sprite");
        addRoutesToShuttle("JKL8", "Tropicana", "Fantasia");
    }
    
    /** Returns the card with the card id specified by the parameter
     * @return the card with the specified id
     **/
    public Card getCard(int id)
    {
        for (Card temp : allCards)
        {
            if (temp.getCardNo() == id)
            {
                return temp;
            }
        }       
        return null;
    }
     
    /** Returns the world with the name specified by the parameter
     * @return the world with the specified name
     **/
    private World getWorld(String worldName)
    {
        for (World temp : allWorlds)
        {
            if (temp.getName().equals(worldName))
            {
                return temp;
            }
        }
        return null;
    }
    
    /** Returns the world with the name specified by the parameter
     * @return the world with the specified name
     **/
    private Shuttle getShuttle(String shut)
    {
        for (Shuttle temp : allShuttles)
        {
            if (temp.getJourneyCode().equals(shut))
            {
                return temp;
            }
        }
        return null;
    }
}