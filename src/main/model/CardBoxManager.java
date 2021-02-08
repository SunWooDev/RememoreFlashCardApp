package model;


/*
Leitner system is a studying technique that uses 1) flash cards and 2) boxes.
For more information about the Leitner system, please read README.md.
CardBoxManager class represents grouping of the 5 card boxes or Leitner system as a whole.
There is only one cardBox manager.
 */


import java.util.ArrayList;
import java.util.List;

public class CardBoxManager {

    //Fields------------------------------------------------------------------------------------------

    private final List<CardBox> listOfCardBoxes; //listOfCardBoxes contains 5 cardBoxes

    //Constructors------------------------------------------------------------------------------------

/*  REQUIRES: X
    EFFECTS:
    Constructs 5 card boxes
    First card box has cardBoxNum of 1 and has default box timer of 0 minutes
    Second card box has cardBoxNum of 1 and has default box timer of 20 minutes
    Third card box has cardBoxNum of 1 and has default box timer of 40 minutes
    Fourth card box has cardBoxNum of 1 and has default box timer of 80 minutes
    Fifth card box has cardBoxNum of 1 and has default box timer of 160 minutes
    Box timer is customizable to suit user's needs

    These five cards are stored in the listOfCardBoxes.

    */

    public CardBoxManager() {
        listOfCardBoxes = new ArrayList<>();

        CardBox cardBoxOne = new CardBox(1, 0);
        CardBox cardBoxTwo = new CardBox(2, 20);
        CardBox cardBoxThree = new CardBox(3, 40);
        CardBox cardBoxFour = new CardBox(4, 80);
        CardBox cardBoxFive = new CardBox(5, 160);

        listOfCardBoxes.add(cardBoxOne);
        listOfCardBoxes.add(cardBoxTwo);
        listOfCardBoxes.add(cardBoxThree);
        listOfCardBoxes.add(cardBoxFour);
        listOfCardBoxes.add(cardBoxFive);

    }

    //Public methods------------------------------------------------------------------------------------

    //REQUIRES: inputCardBoxNum is one of 1,2,3,4,5
    //MODIFIES: X
    //EFFECTS: find the cardBox object in cardBoxManager given cardBoxNumber.
    public CardBox findCardBoxInCardBoxManager(int inputCardBoxNum) {
        //find cardBox in the listOfCardBoxes
        for (CardBox cardBoxInCardBoxManager : listOfCardBoxes) {
            //if inputCardBoxNum matches with CardBox's CardBoxNum in tableOfCard,
            if (cardBoxInCardBoxManager.getCardBoxNum() == inputCardBoxNum) {
                //return the found CardBox
                return cardBoxInCardBoxManager;
            }
            //else keep looking
        }

        //if iteration is done, then it means no cards are found. Return null
        return null;
    }

    //Private methods----------------------------------------------------------------------------------


    //Getters and Setters------------------------------------------------------------------------

    public List<CardBox> getListOfCardBoxes() {
        return listOfCardBoxes;
    }


}
