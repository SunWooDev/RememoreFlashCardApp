package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    //test the first constructor with parameter String inputFrontInfo, String inputBackInfo, int inputTimeUntilTestedAgain
    @Test
    public void testConstructor1() {
        Card cardObj = new Card("What is the color of the sky?", "blue", 2);
        String frontInfo = cardObj.getFrontInfo();
        assertEquals("What is the color of the sky?", frontInfo);

        String backInfo = cardObj.getBackInfo();
        assertEquals("blue", backInfo);

        int cardTimer = cardObj.getTimerUntilTestedAgain();
        assertEquals(2, cardTimer);

        int firstCardID = cardObj.getCardID();
        assertEquals(0, firstCardID);

    }

    //test second constructor with parameter String inputFrontInfo, String inputBackInfo, int inputTimeUntilTestedAgain, int inputID
    @Test
    public void testConstructor2() {
        Card cardObj = new Card("My favorite color?", "red", 77, 5);
        String frontInfo = cardObj.getFrontInfo();
        assertEquals("My favorite color?", frontInfo);

        String backInfo = cardObj.getBackInfo();
        assertEquals("red", backInfo);

        int cardTimer = cardObj.getTimerUntilTestedAgain();
        assertEquals(77, cardTimer);

        int firstCardID = cardObj.getCardID();
        assertEquals(5, firstCardID);

    }

    @Test
    public void testToString() {
        Card cardObj = new Card("What is 1+1?", "2", 20, 3);
        String cardAsString = cardObj.toString();
        String expectedString = "Card{frontInfo='What is 1+1?', backInfo='2', timeUntilTestedAgain=20, ID=3}";
        assertEquals(expectedString, cardAsString);


    }


    //Test Getters and Setters------------------------------------------------------------------------------
    @Test
    public void testGetCardID() {
        Card cardObj = new Card("What is 1+1?", "2", 20, 3);
        assertEquals(3, cardObj.getCardID());
    }


    @Test
    public void testGetFrontInfo() {
        Card cardObj = new Card("What is 1+1?", "2", 20, 3);

        assertEquals("What is 1+1?", cardObj.getFrontInfo());

    }

    @Test
    public void testSetFrontInfo() {
        Card cardObj = new Card("What is 1+1?", "2", 20, 3);
        cardObj.setFrontInfo("What is life?");
        assertEquals("What is life?", cardObj.getFrontInfo());

    }


    @Test
    public void testGetBackInfo() {
        Card cardObj = new Card("What is 1+1?", "Two", 20, 3);
        assertEquals("Two", cardObj.getBackInfo());

    }

    @Test
    public void testSetBackInfo() {
        Card cardObj = new Card("What is 1+1?", "2", 20, 3);
        cardObj.setBackInfo("Number 2");
        assertEquals("Number 2", cardObj.getBackInfo());

    }


    @Test
    public void testGetTimerUntilTestedAgain() {
        Card cardObj = new Card("What is 1+1?", "2", 20, 3);
        assertEquals(20,cardObj.getTimerUntilTestedAgain());
    }

    @Test
    public void testSetTimerUntilTestedAgain() {
        Card cardObj = new Card("What is 1+1?", "2", 20, 3);
        cardObj.setTimerUntilTestedAgain(555);
        assertEquals(555,cardObj.getTimerUntilTestedAgain());
    }



    @Test
    public void testGetNextCardID() {
        //card's nextCardID is a static variable that remembers accumulation from previous card instantiations.
        //Therefore reset the cardID back to 0
        Card.setNextCardID(0);

        assertEquals(0, Card.getNextCardID());


    }

    @Test
    public void testSetNextCardID() {
        Card.setNextCardID( 55 );
        Card cardObj = new Card("What is 1+1?", "2", 20);

        assertEquals( 55, cardObj.getCardID() );
    }




}