
/**
 * CardTester uses the Card class
 *
 * @author Manuel Gomes Rosmaninho
 * @version 09/04/2020
 */
public class CardTester
{
    public static void main(String[] args)
    {   
        // calling the constructor to create an object
        Card c1 = new Card(1, "John", 3, 10);
        // calling an accessor with an expression
        System.out.println(c1.toString());
        
        // calling the constructor to create an object
        Card c2 = new Card(2, "Rob", 5, 8);
        // calling an accessor with an expression
        System.out.println(c2.toString());
        
        // checking card id - calling an accessor
        int id = c1.getCardNo();
        System.out.println("\nThe card no. for c1 is: " + id +
                            c1.toString());
    }
}
