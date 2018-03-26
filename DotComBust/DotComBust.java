import java.util.*;

public class DotComBust {

  private GameHelper helper = new GameHelper();
  private ArrayList <DotCom> dotComsList = new ArrayList<DotCom>();
  private int numOfGuesses = 0;

  private void setUpGame() {

   /* Make three DotCom objects,
    * give 'em names, and stick 'em
    * in the ArrayList.
    */
    // first make some dot coms and give them locations
    DotCom one = new DotCom();
    one.setName("Pets.com");
    DotCom two = new DotCom();
    two.setName("eToys.com");
    DotCom three = new DotCom();
    three.setName("Go2.com");
    dotComsList.add(one);
    dotComsList.add(two);
    dotComsList.add(three);

   /* Print brief instructions for user.
    */
    System.out.println("Your goal is to sink three dot coms.");
    System.out.println("Pets.com, eToys.com, Go2.com");
    System.out.println("Try to sink them all in the fewest number of guesses");

   /* Repeat with each DotCom in the list.
    */
    for(DotCom dotComToSet : dotComsList) {

     /* Ask the helper for a DotCom location
      * (an ArrayList of Strings).
      */
      ArrayList<String> newLocation = helper.placeDotCom(3);

     /* Call the setter method on this DotCom to give it
      * the location you just got from the helper.
      */
      dotComToSet.setLocationCells(newLocation);
    } // close for loop
  } // close setUpGame method

  private void startPlaying() {

   /* As long as the DotCom list is NOT empty (the ! means NOT, it's the same as
    * (dotComListIsEmpty() == false)).
    */
    while(!dotComsList.isEmpty()) {

     /* Get user input.
      */
      String userGuess = helper.getUserInput("Enter a guess");

     /* Call our own checkUserGuess method.
      */
      checkUserGuess(userGuess);
    } // close while

   /* Call our own finishGame method.
    */
    finishGame();
  } // close startPlaying method

  private void checkUserGuess(String userGuess) {

   /* Increment the number of guesses the user has made.
    */
    numOfGuesses++;

   /* Assume it's a `miss`, unless told otherwise.
    */
    String result = "miss";

   /* Repeat with all DotComs in the list.
    */
    for(DotCom dotComToTest : dotComsList) {

     /* Ask the DotCom to check the user guess, looking for a hit (or kill).
      */
      result = dotComToTest.checkYourself(userGuess);

      if(result.equals("hit")) {
       /* Get out of the loop early, no point in testing the others.
        */
        break;
      }
      if(result.equals("kill")) {
       /* This guy's dead, so take him out of the DotComs list, then get out of the loop.
        */
        dotComsList.remove(dotComToTest);
        break;
      }
    } // close for

   /* Print result for the user.
    */
    System.out.println(result);
  } // close method

  private void finishGame() {

   /* Print a message telling the user how he did in the game.
    */
    System.out.println("All Dot Coms are dead! Your stock is now worthless.");
    if(numOfGuesses <= 18) {
      System.out.println("It only took you " + numOfGuesses + " guesses.");
      System.out.println("You got out before your options sank.");
    } else {
      System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
      System.out.println("Fish are dancing with your options.");
    }
  } // close method

  public static void main (String[] args) {

   /* Create the game object.
    */
    DotComBust game = new DotComBust();

   /* Tell the game object to set up the game.
    */
    game.setUpGame();

   /* Tell the game object to start the main game
    * play loop (keeps asking for user input and
    * checking the guess).
    */
    game.startPlaying();
  } // close method
}
