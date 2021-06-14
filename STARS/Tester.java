
/**
 * Tester uses the ResortManager class
 *
 * @author Manuel Gomes Rosmaninho
 * @version 15/04/2020
 */
public class Tester
{
    public void doTest()
    {
        // declare and create the Resort object
        ResortManager wayward = new ResortManager("Asteroids");
        
        // Testing the call of ArrayList method in each class method
        // Large data, should call one at a time
        // Testing ArrayList Cards
        //System.out.print("***** Cards *****");
        //System.out.println(Asteroids.getAllCards());
        // Testing ArrayList Worlds
        //System.out.print("\n***** Worlds *****");
        //System.out.println(Asteroids.getAllWorlds());
        // Testing ArrayList Shuttles
        //System.out.print("\n***** Shuttles *****");
        //System.out.println(Asteroids.getAllShuttles());
        
        // Testing a Travel by a Card (allowed)
        // Find a card's world
        //System.out.println("\n*** Finding a Card 1000's world ***");
        //System.out.println(wayward.findCard(1000));
        //System.out.println("\n*** All Cards on Home World ***");
        //System.out.println(wayward.getAllCardsOnWorld("Home"));
        // Can Travel?
        //System.out.println("*** Check if Card 1000 can travel on shuttle ABC1 ***");
        //System.out.println("Can travel? " + wayward.canTravel(1000, "ABC1"));
        // Travel
        //System.out.println("\n*** Travel Card 1000 on shuttle ABC1 ***");
        //System.out.println("Travel: " + wayward.travel(1000, "ABC1"));
        // Find a card's world
        //System.out.println("\n*** Finding a Card 1000's world ***");
        //System.out.println(wayward.findCard(1000));
        //System.out.println("\n*** All Cards on Home World ***");
        //System.out.println(wayward.getAllCardsOnWorld("Home"));
        //System.out.println("\n*** All Cards on Sprite World ***");
        //System.out.println(wayward.getAllCardsOnWorld("Sprite"));
        //System.out.println("\n*** moveHome Test ***");
        //wayward.moveHome(1000);
        //System.out.println(wayward.findCard(1000));
        //System.out.println(wayward.getAllCardsOnWorld("Home"));
        
        // Testing a Travel by a Card (First allowed and second not allowed)
        // Find a card's world (First Travel - allowed)
        //System.out.println("\n*** First Travel - allowed ***");
        //System.out.println("\n*** Finding a Card 1003's world ***");
        //System.out.println(wayward.findCard(1003));
        //System.out.println("\n*** All Cards on Home World ***");
        //System.out.println(wayward.getAllCardsOnWorld("Home"));
        // Can Travel?
        //System.out.println("*** Check if Card 1003 can travel on shuttle ABC1 ***");
        //System.out.println("Can travel? " + wayward.canTravel(1003, "ABC1"));
        // Travel
        //System.out.println("\n*** Travel Card 1003 on shuttle ABC1 ***");
        //System.out.println("Travel: " + wayward.travel(1003, "ABC1"));
        // Find a card's world
        //System.out.println("\n*** Finding a Card 1003's world ***");
        //System.out.println(wayward.findCard(1003));
        //System.out.println("\n*** All Cards on Home World ***");
        //System.out.println(wayward.getAllCardsOnWorld("Home"));
        //System.out.println("\n*** All Cards on Sprite World ***");
        //System.out.println(wayward.getAllCardsOnWorld("Sprite"));
        // Find a card's world (Second Travel - not allowed)
        //System.out.println("\n*** Second Travel - not allowed ***");
        //System.out.println("\n*** Finding a Card 1003's world ***");
        //System.out.println(wayward.findCard(1003));
        //System.out.println("\n*** All Cards on Sprite World ***");
        //System.out.println(wayward.getAllCardsOnWorld("Sprite"));
        // Can Travel?
        //System.out.println("*** Check if Card 1003 can travel on shuttle CDE3 ***");
        //System.out.println("Can travel? " + wayward.canTravel(1003, "CDE3"));
        // Travel
        //System.out.println("\n*** Travel Card 1003 on shuttle CDE3 ***");
        //System.out.println("Travel: " + wayward.travel(1003, "CDE3"));
        // Find a card's world
        //System.out.println("\n*** Finding a Card 1003's world ***");
        //System.out.println(wayward.findCard(1003));
        //System.out.println("\n*** All Cards on Sprite World ***");
        //System.out.println(wayward.getAllCardsOnWorld("Sprite"));
        //System.out.println("\n*** All Cards on Tropicana World ***");
        //System.out.println(wayward.getAllCardsOnWorld("Tropicana"));
        
        // Testing advanced features
        // Travel 1
        System.out.println("Travel1: " + wayward.travel(1000, "ABC1"));
        System.out.println("Travel1: " + wayward.travel(1001, "ABC1"));
        System.out.println("Travel1: " + wayward.travel(1003, "ABC1"));
        System.out.println("Travel1: " + wayward.travel(1004, "ABC1"));
        System.out.println("Travel1: " + wayward.travel(1005, "ABC1"));
        System.out.println("Travel1: " + wayward.travel(1006, "ABC1"));
        System.out.println("Travel1: " + wayward.travel(1007, "ABC1"));
        System.out.println("Travel1: " + wayward.travel(1008, "ABC1"));
        // Travel 2
        System.out.println("Travel2: " + wayward.travel(1005, "BCD2"));
        System.out.println("Travel2: " + wayward.travel(1000, "CDE3"));
        System.out.println("Travel2: " + wayward.travel(1001, "CDE3"));
        System.out.println("Travel2: " + wayward.travel(1006, "CDE3"));
        System.out.println("Travel2: " + wayward.travel(1007, "CDE3"));
        System.out.println("Travel2: " + wayward.travel(1008, "CDE3"));
        System.out.println("Travel2: " + wayward.travel(1003, "GHJ6"));
        // Travel 3
        System.out.println("Travel3: " + wayward.travel(1007, "JKL8"));
        System.out.println("Travel3: " + wayward.travel(1008, "JKL8"));
        // Checking if all travelled
        //System.out.println("All Cards on each World after travels: " + wayward.getAllCardsOnEachWorld());
        // topUpCredits
        System.out.println("topUpCredits\n");
        wayward.topUpCredits(1007, 10);
        wayward.topUpCredits(1002, 5);
        // convertPoints
        System.out.println("convertPoints\n");
        wayward.convertPoints(1003);
        wayward.convertPoints(1005);
        wayward.convertPoints(1006);
        wayward.convertPoints(1008);
        // moveHome
        System.out.println("moveHome\n");
        wayward.moveHome(1001);
        wayward.moveHome(1007);
        // Checking if worked topUpCredits, convertPoints, moveHome
        System.out.println("All Cards on each World after advanced features: " + wayward.getAllCardsOnEachWorld());
        // evacuateAll
        System.out.println("evacuateAll\n\n");
        wayward.evacuateAll();
        System.out.println("All Cards on each World after evacuated: " + wayward.getAllCardsOnEachWorld());
        
        // Testing travel error messages
        System.out.println("Travel01: " + wayward.travel(1000, "ABC1"));
        System.out.println("Travel02: " + wayward.travel(1000, "GHJ6"));
        System.out.println("TopUpCredits");
        wayward.topUpCredits(1000, 10);
        System.out.println("Travel03: " + wayward.travel(1000, "GHJ6"));
        System.out.println("Travel04: " + wayward.travel(1001, "ABC1"));
        System.out.println("Travel05: " + wayward.travel(1001, "GHJ6"));
        System.out.println("Travel06: " + wayward.travel(1001, "CDE3"));
        System.out.println("Travel07: " + wayward.travel(1001, "JKL8"));
        System.out.println("Travel08: " + wayward.travel(1001, "ABC1"));
    }
}