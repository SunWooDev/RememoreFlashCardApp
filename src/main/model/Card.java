package model;

/*
Leitner system is a studying technique that uses 1) flash cards and 2) boxes.
For more information about the Leitner system, please read README.md.
Card class represents a flash card that users use to study and test themselves.
Flash card has front side and back side.
Front side is where users type in their question.
Back side is where users type in their answer.

 */

public class Card {


    //Fields------------------------------------------------------------------------------------------
    private String frontInfo; //front side of the card where user types in a question
    private String backInfo; //back side of the card where user types in the answer

/*  timerUntilTestedAgain represents minutes until the card can be tested again.
    The reason why there timer for cardBox and card is that there can be two cards with different timer in the same box.
    For example, let's say that first box has timer of 30 minutes.
    This happens when the user creates a card in the first box, close the application for 10 minutes,
    and create another card in the same box.
    The card created earlier has 20 minutes left and the recently created card has 30 minutes left until it is ready
    to be tested again.
    Hence, CardBox's timer represents initial value is Card's timer
    Card timer ticks down when the application is closed.
    */
    private int timerUntilTestedAgain;
    private final int cardID; //card ID is unique
    private static int nextCardID; //tracks ID of next card created


    //Constructors------------------------------------------------------------------------------------

/*  REQUIRES: inputTimeUntilTestedAgain >= 0 as the timer can not be negative.
    EFFECTS:
    constructs card object and sets the initial values
    frontInfo is set to inputFrontInfo
    backInfo is set to inputBackInfo
    timerUntilTestedAgain is set inputTimeUntilTestedAgain
    cardID is unique positive integer not assigned to any other card
    */
    public Card(String inputFrontInfo, String inputBackInfo, int inputTimeUntilTestedAgain) {
        frontInfo = inputFrontInfo;
        backInfo = inputBackInfo;
        timerUntilTestedAgain = inputTimeUntilTestedAgain;
        cardID = nextCardID;
        nextCardID++;
    }

    /*  REQUIRES: inputTimeUntilTestedAgain >= 0 as the timer can not be negative.
        EFFECTS:
        constructs card object and sets the initial values
        frontInfo is set to inputFrontInfo
        backInfo is set to inputBackInfo
        timerUntilTestedAgain is set inputTimeUntilTestedAgain
        cardID is set to inputID
        */
    public Card(String inputFrontInfo, String inputBackInfo, int inputTimeUntilTestedAgain, int inputID) {
        frontInfo = inputFrontInfo;
        backInfo = inputBackInfo;
        timerUntilTestedAgain = inputTimeUntilTestedAgain;
        cardID = inputID;

    }



    //Public methods------------------------------------------------------------------------------------

    //REQUIRES: X
    //MODIFIES: X
    //EFFECTS: represent Card object as string
    @Override
    public String toString() {
        return "Card{"
                + "frontInfo='" + frontInfo
                + '\''
                + ", backInfo='" + backInfo
                + '\''
                + ", timeUntilTestedAgain=" + timerUntilTestedAgain
                + ", ID=" + cardID
                + '}';
    }

    //Private methods----------------------------------------------------------------------------------


    //Getters and Setters------------------------------------------------------------------------
    public int getCardID() {
        return cardID;
    }



    public String getFrontInfo() {
        return frontInfo;
    }

    public void setFrontInfo(String frontInfo) {
        this.frontInfo = frontInfo;
    }



    public String getBackInfo() {
        return backInfo;
    }

    public void setBackInfo(String backInfo) {
        this.backInfo = backInfo;
    }



    public int getTimerUntilTestedAgain() {
        return timerUntilTestedAgain;
    }

    public void setTimerUntilTestedAgain(int timerUntilTestedAgain) {
        this.timerUntilTestedAgain = timerUntilTestedAgain;
    }




    public static int getNextCardID() {
        return nextCardID;
    }

    public static void setNextCardID(int inputIDCounter) {
        nextCardID = inputIDCounter;
    }

}

