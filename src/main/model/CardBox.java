package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CardBox {

    //Fields------------------------------------------------------------------

    private final List<Card> tableOfCards; //holds the cards in this particular box
    private final List<Card> testableTableOfCards; //holds the cards that are testable (card timer ran out)
    private final int cardBoxNum; //cardBoxNum is unique and is one of 1,2,3,4,5
    private int boxMinutesTimer; //timer associated with the box

    //Constructors------------------------------------------------------------------

/*  REQUIRES:
    inputCardBoxNum is one of 1,2,3,4,5.
    inputBoxTimer >=0 as timer can't be negative
    EFFECTS:
    Constructs a CardBox object and sets the initial values
    tableOfCards is set a new array list
    cardBoxNum is set inputCardBoxNum
    boxMinutesTimer is set inputBoxTimer
    testableTableOfCards is set new array list
    */
    public CardBox(int inputCardBoxNum, int inputBoxTimer) {
        tableOfCards = new ArrayList<>();
        cardBoxNum = inputCardBoxNum;
        boxMinutesTimer = inputBoxTimer;
        testableTableOfCards = new ArrayList<>();
    }


    //Public Methods----------------------------------------------------------------

    //REQUIRES: X
    //MODIFIES: this
    //EFFECTS: constructs a new card given a card's front side information and back side information and add the card
    //to the tableOfCards
    public void addCard(String inputFrontInfo, String inputBackInfo) {
        //initial card timer is box timer.
        int boxMinutesTimer = getBoxMinutesTimer();
        //make a card
        Card newCard = new Card(inputFrontInfo, inputBackInfo, boxMinutesTimer);

        //add card into the table of cards
        tableOfCards.add(newCard);
    }

    //REQUIRES: inputID must be existing card ID in the tableOfCards.
    //MODIFIES: this
    //EFFECTS: removes the card given inputID in the tableOfCards
    public void removeCard(int inputID) {
        Card cardToRemoveFound = findCardInCardBox(inputID);

        //if card is found
        if (cardToRemoveFound != null) {
            //remove the card
            tableOfCards.remove(cardToRemoveFound);
        }

    }

    //REQUIRES: inputID must be existing card ID in the tableOfCards.
    //MODIFIES: Card
    //EFFECTS: modify the content of the front side (question) and back side (answer) of the card found given inputID
    public void modifyCard(int inputID, String inputModifiedFrontInfo, String inputModifiedBackInfo) {
        Card cardToModifyFound = findCardInCardBox(inputID);
        //if card is found
        if (cardToModifyFound != null) {
            //change the front and back info
            cardToModifyFound.setFrontInfo(inputModifiedFrontInfo);
            cardToModifyFound.setBackInfo(inputModifiedBackInfo);
        }

    }

    //REQUIRES: inputID must be existing card ID in the tableOfCards.
    //MODIFIES: this, inputToCardBox
    //EFFECTS: moves the card from this box object to inputToCardBox given inputID of a card
    public void moveCardToDifferentBox(int inputID, CardBox inputToCardBox) {
        Card cardToMoveFound = findCardInCardBox(inputID);
        //if card is found
        if (cardToMoveFound != null) {
            //move the card to another box
            inputToCardBox.getTableOfCards().add(cardToMoveFound);
            tableOfCards.remove(cardToMoveFound);
        }

    }

    //REQUIRES: X
    //MODIFIES: this
    //EFFECTS: shuffles testableTableOfCards to get ready to test the cards.
    public boolean readyToTestCards() {
        //find cards that have expired timer
        findCardsToTest();
        //if there are cards in the testableTableOfCards
        if (testableTableOfCards.size() != 0) {
            //shuffle the testableTableOfCards
            Collections.shuffle(testableTableOfCards);
            return true;
        }
        return false;
        //otherwise, there is no shuffle if there are no cards in the testableTableOfCards
    }

    //REQUIRES: inputBoxTimer >=0 as timer can't be negative
    //MODIFIES: this
    //EFFECTS: overwrite the current box timer to inputBoxTimer
    public void modifyBoxDueTimer(int inputBoxTimer) {
        setBoxMinutesTimer(inputBoxTimer);

    }

    //REQUIRES: inputID must be existing card ID in the tableOfCards.
    //MODIFIES: X
    //EFFECTS: returns the card given input card ID.
    public Card findCardInCardBox(int inputID) {
        //find in the tableOfCards
        for (Card cardInTableOfCards : tableOfCards) {
            //if inputID matches with card's ID in tableOfCard,
            if (cardInTableOfCards.getCardID() == inputID) {
                //return the found card
                return cardInTableOfCards;
            }
            //else keep looking
        }
        //if iteration is done, then it means no cards are found. Return null
        return null;
    }





    //Private Methods-------------------------------------------------------------------------
    //REQUIRES: X (if tableOfCards is empty, then it is guaranteed that there are no cards to test)
    //MODIFIES: this
    //EFFECTS: finds cards with expired timer (timer == 0) in tableOfCards and put them into testableTableOfCards
    private void findCardsToTest() {
        //find card in the tableOfCards
        for (Card cardInTableOfCards : tableOfCards) {
            //if the card has boxTimer of 0
            if (cardInTableOfCards.getTimerUntilTestedAgain() == 0) {
                //move into testableTableOfCards
                testableTableOfCards.add(cardInTableOfCards);
            }
        }
    }


    //Getters and setters--------------------------------------------------------------------------

    public int getCardBoxNum() {
        return cardBoxNum;
    }

    public int getBoxMinutesTimer() {
        return boxMinutesTimer;
    }

    public void setBoxMinutesTimer(int inputBoxTimer) {
        boxMinutesTimer = inputBoxTimer;
    }

    public List<Card> getTableOfCards() {
        return tableOfCards;
    }

    public List<Card> getTestableTableOfCards() {
        return testableTableOfCards;
    }


}