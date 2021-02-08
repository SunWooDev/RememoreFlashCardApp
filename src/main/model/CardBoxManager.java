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



    //REQUIRES: inputCurrentCardToTest is an existing card in inputCurrentCardBox's testTableTableOfCards
    //MODIFIES: inputCurrentCardBox, inputCurrentCardBox
    //EFFECTS: When testing a card, when the user get it correct, the card moves to the next box
    // and card timer is set to the next box's timer.
    //If the card is in the last box, the card stays in the last box and timer is reset to the last box's timer.
    public void gotAnswerCorrectly(Card inputCurrentCardToTest, CardBox inputCurrentCardBox) {

        //if answered correctly and card is at the last box
        if (inputCurrentCardBox.getCardBoxNum() == getListOfCardBoxes().size()) {
            //card stays and card timer resets
            inputCurrentCardToTest.setTimerUntilTestedAgain(inputCurrentCardBox.getBoxMinutesTimer());
        } else {
            //else, if answered correctly and card is not at the last box
            //move the card to next box
            CardBox nextBox = findCardBoxInCardBoxManager(inputCurrentCardBox.getCardBoxNum() + 1);
            inputCurrentCardBox.moveCardToDifferentBox(inputCurrentCardToTest.getCardID(),nextBox);
            //set the timer to next box's timer
            inputCurrentCardToTest.setTimerUntilTestedAgain(nextBox.getBoxMinutesTimer());
        }

    }


    //REQUIRES: inputCurrentCardToTest is an existing card in inputCurrentCardBox's testTableTableOfCards
    //MODIFIES: inputCurrentCardBox, inputCurrentCardBox
    //EFFECTS: When testing a card, when the user get it incorrect, the card moves to the previous box
    //and card timer is set to the previous box's timer.
    // If the card is in the first box, the card stays in the first box and timer is reset to the first box's timer.
    public void gotAnswerIncorrectly(Card inputCurrentCardToTest, CardBox inputCurrentCardBox) {
        //if answered incorrectly and card is at the first box
        if (inputCurrentCardBox.getCardBoxNum() == 1) {
            //card stays and card timer resets
            inputCurrentCardToTest.setTimerUntilTestedAgain(inputCurrentCardBox.getBoxMinutesTimer());

        } else {
            //else answered incorrectly and card is not at the first box
            //move the card to one box behind
            CardBox previousBox = findCardBoxInCardBoxManager(inputCurrentCardBox.getCardBoxNum() - 1);
            inputCurrentCardBox.moveCardToDifferentBox(inputCurrentCardToTest.getCardID(),previousBox);
            //set the timer to the previous box's timer
            inputCurrentCardToTest.setTimerUntilTestedAgain(previousBox.getBoxMinutesTimer());
        }

    }

    //Private methods----------------------------------------------------------------------------------


    //Getters and Setters------------------------------------------------------------------------

    public List<CardBox> getListOfCardBoxes() {
        return listOfCardBoxes;
    }


}
