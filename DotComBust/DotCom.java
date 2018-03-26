import java.util.*;

public class DotCom {

 /* DotCom's instance variables.
  */
  private ArrayList<String> locationCells; // an ArrayList of cell locations
  private String name;                      // the DotCom's name

 /* A setter method that updates the DotCom's location (Random location provided
  * by the GameHelper placeDotCom() method).
  */
  public void setLocationCells(ArrayList<String> loc) {
    locationCells = loc;
  }

 /* Your basic setter method.
  */
  public void setName(String n) {
    name = n;
  }

  public String checkYourself(String userInput) {
    String result = "miss";
    int index = locationCells.indexOf(userInput);
    if(index >= 0) {
      locationCells.remove(index);  // Using ArrayList's remove() method to delete an entry.

     /* Using the `isEmpty()` method to see if all of the locations have been guessed.
      */
      if(locationCells.isEmpty()) {
        result = "kill";
        System.out.println("Ouch! You sunk " + name + " :-( "); // Tell us whether a DotCom has been sunk.
      } else {
        result = "hit";
      }
    } // close if

    return result;  // Return `miss`, `hit`, or `kill`.
  } // close method
} // close class
