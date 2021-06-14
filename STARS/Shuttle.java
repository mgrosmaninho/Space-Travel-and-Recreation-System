
/**
 * Used to store information about Shuttle
 * Journey Code
 *
 * @author Manuel Gomes Rosmaninho
 * @version 11/04/2020
 */

public class Shuttle
{
    //Shuttle Fields
    private String journeyCode;
    private Card caNo;
    private World wSrc;
    private World wDstn;
    
    /** Creates a Shuttle
     * @param jcode represents the Shuttle's code
     */
    public Shuttle(String jcode)
    {
        journeyCode = jcode;
    }

    /** Returns the Shuttle's code
     * @return Shuttle code
     */
    public String getJourneyCode()
    {
       return journeyCode;
    }
   
    /** Add Card to travel
     * @param cN is the reference to the Card object
     */
    public void addCardToTravel(Card cN)
    {
        caNo = cN;
    }
    
    /** Returns the Card details
     * @return card details
     */
    public Card getCardDetails()
    {
        return caNo;
    }
    
    /** Add World source
     * @param wS is the reference to the World object
     */
    public void addWorldSource(World wS)
    {
        wSrc = wS;
    }
    
    /** Returns the World source details
     * @return source details
     */
    public World getSourceDetails()
    {
        return wSrc;
    }
    
    /** Add World destination
     * @param wD is the reference to the World object
     */
    public void addWorldDestination(World wD)
    {
        wDstn = wD;
    }
    
    /** Returns the World destination details
     * @return destination details
     */
    public World getDestinationDetails()
    {
        return wDstn;
    }
    
    /** Returns true if a Card luxury rating is higher or equal to the
     * rating of the destination world, false otherwise
     * @return true if the card luxury rating is higher or equal to the
     * the destination world, false otherwise
     */
    public boolean testLuxuryRating()
    {
        int cardLux = caNo.getLuxuryRating();
        int worldLux = wDstn.getRating();
        return cardLux >= worldLux;
    }
    
    /** Returns true if a Card has enough credits for the journey,
     * false otherwise
     * @return true if the card has enough credits, false otherwise
     */
    public boolean testCredits()
    {
        int cardCredits = caNo.getNoOfCredits();
        return cardCredits >= 3;
    }
    
    /** Returns true if the arrival of the card would NOT exceed the
     * maximum capacity of the destination world, false otherwise
     * @return true if the arrival of the card would NOT exceed the
     * capacity of the destination world, false otherwise
     */
    public boolean testCapacity()
    {
        int worldCap = wDstn.getCapacity();
        int worldNoCards = wDstn.noOfCards();
        return worldCap >= worldNoCards + 1;
    }
    
    /** Returns true if a Card is listed in the source world of the
     * shuttle, false otherwise
     * @return true if the card is listed in the source world, false otherwise
     */
    public boolean testLocation()
    {
        int c = caNo.getCardNo();
        return wSrc.isOnList(c);
    }
    
    /** Returns true if a Card is allowed to move using the shuttle, false otherwise
     * A move can be made if:  
     * the rating of the card  >= the rating of the destination world
     * AND the destination world is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source world
     * AND the card id is for a card on the system
     * AND the shuttle code is the code for a shuttle on the system
     * @return true if the card is allowed on the shuttle journey, false otherwise 
     **/
    public boolean canTravel()
    {
        return testLuxuryRating() && testCapacity() && testCredits() && testLocation();
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
     * @return a String giving the result of the request
     **/
    public String travel()
    {
        if (testLuxuryRating())
        {
            if (testCapacity())
            {
                if (testCredits())
                {
                    if (testLocation())
                    {
                        caNo.payTravel();
                        int cl = caNo.getCardNo();
                        wSrc.leave(cl);
                        wDstn.enter(caNo);
                        return "The card number " + cl + 
                               " travelled to " + wDstn.getName() + " World\n";
                    }
                    return "You are not in the correct World\n";
                }
                return "You don't have enough credits\n";
            }
            return "The World destination is full\n";
        }
        return "You don't have the luxury rating of the destination World\n";
    }
    
    /** Returns a String representation of the Shuttle information
     * @return the Shuttle information as a String
     */
    public String toString()
    {
        return("\nJourney Code: " + journeyCode +
               "\nFrom: " + wSrc +
               "\nTo: " + wDstn);
    }
}
