
/**
 * Used to store information about a Card
 * Card ID number
 * Name
 * Luxury rating
 * Number of credits
 * Number of loyalty points
 *
 * @author Manuel Gomes Rosmaninho
 * @version 09/04/2020
 */

public class Card
{
    //Card Fields
    private int cardNo;
    private String name;
    private int luxuryRating;
    private int noOfCredits;
    private int noOfLoyalty;

    /** Creates a Card
     * @param cNo represents the card's number
     * @param n represents the name
     * @param lRat represents the luxury rating
     * @param nCred represents the number of credits
     */
    public Card(int cNo, String n, int lRat, int nCred)
    {
        cardNo = cNo;
        name = n;
        luxuryRating = lRat;
        noOfCredits = nCred;
        noOfLoyalty = 0;
    }

    /** Returns the card's number
     * @return card number
     */
    public int getCardNo()
    {
        return cardNo;
    }
    
    /** Returns the person's name
     * @return name
     */
    public String getName()
    {
        return name;
    }
    
    /** Returns the luxury rating
     * @return luxury rating
     */
    public int getLuxuryRating()
    {
        return luxuryRating;
    }
    
    /** Returns the number of credits
     * @return number of credits
     */
    public int getNoOfCredits()
    {
        return noOfCredits;
    }
    
    /** Returns the number of loyalty points
     * @return number of loyalty points
     */
    public int getNoOfLoyalty()
    {
        return noOfLoyalty;
    }
    
    /** Receive an amount of credit
     * Check that the amount is sensible
     * @param amount is the quantity of credits to insert
     */
    public void insertCredit(int amount)
    {
        if(amount > 0)
        {
            noOfCredits = noOfCredits + amount;
        }
    }
    
    /** Deduct an amount of credit
     * Check that the amount is sensible
     * @param amount is the quantity of credits to deduct
     */
    public void deductCredit(int amount)
    {
        if(amount > 0)
        {
            noOfCredits = noOfCredits - amount;
        }
    }
    
    /** Convert loyalty points to credits
     * Check that have enough loyalty points to convert
     */
    public void convertLoyaltyToCredit()
    {
        if(noOfLoyalty >= 4)
        {
            int totalCredits = noOfLoyalty / 4;
            noOfLoyalty %= 4;
            noOfCredits = noOfCredits + totalCredits;
        }
    }
    
    /** Check if have enough credits to take a shuttle
     * @return true if have enough credits for a shuttle
     */
    public boolean enoughCreditShuttle()
    {
        return noOfCredits >= 3;
    }
    
    /** Returns a String representation of the card information
     * @return the card information as a String
     */
    public String toString()
    {
        return("Card No: " + cardNo +
               "\nName: " + name +
               "\nLuxury rating: " + luxuryRating +
               "\nCredits: " + noOfCredits +
               "\nLoyalty points: " + noOfLoyalty +
               "\n");
    }
    
    /** Deduct credits and add loyalty points as a shuttle payment
     * 
     */
    public void payTravel()
    {
        noOfCredits = noOfCredits - 3;
        noOfLoyalty = noOfLoyalty + 2;
    }
}
