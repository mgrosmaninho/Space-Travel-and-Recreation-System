
/**
 * My tester for the entire program.
 * 
 * @author Manuel Gomes Rosmaninho 
 * @version 09/04/2020
 */
public class MyTester 
{   
    public void doTest1()
    { 
        // Test Card Class
        System.out.println("*** CARD ***");
        Card c1 = new Card(1, "John", 3, 10);
        Card c2 = new Card(2, "Rob", 5, 2);
        Card c3 = new Card(3, "Mark", 1, 12);
        //System.out.println(c1.toString());
        //System.out.println(c2.toString());
        //System.out.println(c3.toString());
        System.out.println("*** DONE ***");
        
        // Test World Class
        System.out.println("*** WORLD ***");
        World w1 = new World(1, "MyHome", 0, 10);
        World w2 = new World(2, "Mars", 3, 2);
        World w3 = new World(3, "Cadbury", 1, 1);
        System.out.println("*** Enter **");
        w1.enter(c1);
        w1.enter(c2);
        w1.enter(c3);
        w1.enter(4, "Tarina", 2, 3);
        w1.enter(new Card(5, "Birolha", 3, 5));
        w1.enter(new Card(6, "Zarolha", 3, 5));
        //System.out.println(w1.toString());
        //System.out.println(w2.toString());
        //System.out.println(w3.toString());
        System.out.println("*** DONE ***");
        
        // Test Shuttle Class
        System.out.println("*** SHUTTLE ***");
        Shuttle s1 = new Shuttle("A1");
        Shuttle s2 = new Shuttle("B2");
        Shuttle s3 = new Shuttle("C3");
        System.out.println("*** Source & Destination ***");
        s1.addWorldSource(w1);
        s2.addWorldSource(w2);
        s3.addWorldSource(w3);
        s1.addWorldDestination(w2);
        s2.addWorldDestination(w3);
        s3.addWorldDestination(w1);
        System.out.println("*****");
        System.out.println("*** TRAVEL 1 ***");
        s1.addCardToTravel(c1);
        System.out.println(w1.toString());
        System.out.println(w2.toString());
        System.out.println("before " + s1.getCardDetails());
        System.out.println("canTravel? " + s1.canTravel());
        System.out.println("Travel: " + s1.travel());
        System.out.println("after " + s1.getCardDetails());
        System.out.println(w1.toString());
        System.out.println(w2.toString());
        System.out.println("*** TRAVEL 2 ***");
        s2.addCardToTravel(c1);
        System.out.println(w2.toString());
        System.out.println(w3.toString());
        System.out.println("before " + s2.getCardDetails());
        System.out.println("canTravel? " + s2.canTravel());
        System.out.println("Travel: " + s2.travel());
        System.out.println("after " + s2.getCardDetails());
        System.out.println(w2.toString());
        System.out.println(w3.toString());
        System.out.println("*** TRAVEL 3 ***");
        s1.addCardToTravel(c2);
        System.out.println(w1.toString());
        System.out.println(w2.toString());
        System.out.println("before " + s1.getCardDetails());
        System.out.println("canTravel? " + s1.canTravel());
        System.out.println("Travel: " + s1.travel());
        System.out.println("after " + s1.getCardDetails());
        System.out.println(w1.toString());
        System.out.println(w2.toString());
        //System.out.println(s1.toString());
        //System.out.println(s2.toString());
        //System.out.println(s3.toString());
        System.out.println("*** DONE ***");
    }
     
    
}
