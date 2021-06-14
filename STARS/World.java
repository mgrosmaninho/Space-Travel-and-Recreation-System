import java.util.ArrayList;

/**
 * Used to store information about World
 * World number
 * Name
 * Rating
 * Capacity
 *
 * @author Manuel Gomes Rosmaninho
 * @version 10/04/2020
 */

public class World
{
    //World Fields
    private int worldNo;
    private String name;
    private int rating;
    private int capacity;
    
    private ArrayList<Card> cardList = new ArrayList<Card>();

    /** Creates a World
     * @param wNo represents the World's number
     * @param nme represents the World's name
     * @param rtg represents the World's rating
     * @param cpty represents the World's capacity
     */
    public World(int wNo, String nme, int rtg, int cpty)
    {
        worldNo = wNo;
        name = nme;
        rating = rtg;
        capacity = cpty;
    }

    /** Returns the World's number
     * @return World number
     */
    public int getWorldNo()
    {
        return worldNo;
    }
    
    /** Returns the World's name
     * @return World name
     */
    public String getName()
    {
        return name;
    }
    
    /** Returns the World's rating
     * @return World rating
     */
    public int getRating()
    {
        return rating;
    }
    
    /** Returns the World's capacity
     * @return World capacity
     */
    public int getCapacity()
    {
        return capacity;
    }
    
    /** Returns a String representation of the World information
     * @return the World information as a String
     */
    public String toStringWorld()
    {
        return ("World No: " + worldNo +
                "\nName: " + name + "\n");
    }
    
    /** Adds a Card object to the ArrayList
     * @param cNb is the reference to the Card object
     */
    public void enter(Card cNb)
    {
        if (checkSpacesLeft())
        {
            cardList.add(cNb);
        }
    }
    
    /** Adds a Card object to the ArrayList
     * @param cN represents the card's number
     * @param nm represents the name
     * @param lR represents the luxury rating
     * @param nCr represents the number of credits
     */
    public void enter(int cN, String nm, int lR, int nCr)
    {
        if (checkSpacesLeft())
        {
            Card temp = new Card(cN,nm,lR,nCr);
            cardList.add(temp);
        }
    }
    
    /** Removes a Card from the ArrayList
     * @param cNo represents the card's number
     */
    public void leave(int cNo)
    {
        Card temp = findCard(cNo);
        if (temp != null)
        {
            cardList.remove(temp);
        }
    }
    
    /** Returns a String if the World is full or the remaining spaces
     * @return String full or remaining spaces
     */
    public String spacesLeft()
    {
        if (checkSpacesLeft())
        {
            int spacesLeft = capacity - noOfCards();
            return ("This world has " + spacesLeft +
                    " space(s) left");
        }    
        return "World full";
    }
    
    /** Returns true or false for a specific Card
     * @return true or false
     */
    public boolean checkSpacesLeft()
    {
        return noOfCards() < capacity;
    }
    
    /** Returns a list of Cards in the World or no cards
     * @return list of Cards or no cards
     */
    public String getCardList()
    {
        String ss = "";
        if (cardList.size() > 0)
        {
            for (Card temp: cardList)
            {
                ss = ss + "\n" + temp.toString();
            }
            return ss;
        }
        return "\nNo cards in this World\n";
    }
    
    /** Returns true or false for a specific Card
     * @param cNo represents the card's number
     * @return true if card is in the list, false otherwise
     */
    public boolean isOnList(int cNo)
    {
        for (Card temp : cardList)
        {
            if (temp.getCardNo() == cNo)
            {
                return true;
            }
        }
        return false;
    }
    
    /** Returns a String representation of the World information with Card list
     * @return the World information as a String
     */
    public String toString()
    {
        return ("World No: " + worldNo +
                "\nName: " + name +
                "\n***CardList***" + getCardList());
    }
    
    /** Returns if a Card is in the world
     * @param cNo represents the card's number
     * @return Card details, null otherwise
     */
    public Card findCard(int cNo)
    {
        for (Card temp : cardList)
        {
            if (temp.getCardNo() == cNo)
            {
                return temp;
            }
        }
        return null;
    }
    
    /** Returns the number of Cards in a specific World
     * @return number of Cards
     */
    public int noOfCards()
    {
        // ArrayList method
        return cardList.size();
    }
}