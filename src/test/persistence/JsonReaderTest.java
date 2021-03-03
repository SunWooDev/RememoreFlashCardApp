package persistence;


import model.CardBox;
import model.CardBoxManager;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;


public class JsonReaderTest {


    @Test
    public void testConstructor() {
        CardBoxManager cardBoxManager = new CardBoxManager();
        //JsonReader Constructor
        JsonReader reader = new JsonReader("./data/testReaderBlankSavedCards.json", cardBoxManager );


        assertEquals(cardBoxManager, reader.getSoleCardBoxManager());

        assertEquals("./data/testReaderBlankSavedCards.json", reader.getSource());


    }


    @Test
    public void testReadNonExistingSavedCardsFile() {
        CardBoxManager cardBoxManager = new CardBoxManager();
        //JsonReader Constructor
        JsonReader reader = new JsonReader("./data/thisFileDoesntExist.json", cardBoxManager );

        try {
//            CardBoxManager loadedCardBoxManager = reader.read();
            reader.read();
            fail("IOException Expected");
        } catch (IOException e) {
            System.out.println("Unable to read from file" );
            //pass
        } catch (JSONException e) {
            System.out.println("There is nothing to read or incorrect formatting");
            fail("There is nothing to read or incorrect formatting");
        } catch (ParseException e) {
            System.out.println("Incorrect Date Formatting");
            fail("Incorrect Date Formatting");
        }

    }


    //test when the file is completely empty
    @Test
    public void testReadBlankSavedCardsFile() {
        CardBoxManager cardBoxManager = new CardBoxManager();
        //JsonReader Constructor
        JsonReader reader = new JsonReader("./data/testReaderBlankSavedCards.json", cardBoxManager );

        try {
            //CardBoxManager loadedCardBoxManager = reader.read();
            reader.read();

            fail("JSONException Expected");

        } catch (IOException e) {
            System.out.println("Unable to read from file" );
            fail("Unable to read from file");
        } catch (JSONException e) {
            System.out.println("There is nothing to read or incorrect formatting");
            //pass
        } catch (ParseException e) {
            System.out.println("Incorrect Date Formatting");
            fail("Incorrect Date Formatting");
        }


    }

    //test when the file has some cards
    @Test
    public void testReadNonEmptySavedCardsWrongDateFormat() {
        CardBoxManager cardBoxManager = new CardBoxManager();
        //JsonReader Constructor
        JsonReader reader = new JsonReader("./data/testReaderNonEmptySavedCardsWrongDateFormat.json",
                cardBoxManager );

        try {
//            CardBoxManager loadedCardBoxManager = reader.read();
            reader.read();
            fail("ParseException Expected");



        } catch (IOException e) {
            System.out.println("Unable to read from file" );
            fail("Unable to read from file");
        } catch (JSONException e) {
            System.out.println("There is nothing to read or incorrect formatting");
            fail("There is nothing to read or incorrect formatting");
        } catch (ParseException e) {
            System.out.println("Incorrect Date Formatting");
            //pass
        }

    }



    //test when the file is empty of cards
    @Test
    public void testReadEmptySavedCards() {

        CardBoxManager cardBoxManager = new CardBoxManager();
        //JsonReader Constructor
        JsonReader reader = new JsonReader("./data/testReaderEmptySavedCards.json", cardBoxManager );

        try {
            //CardBoxManager loadedCardBoxManager = reader.read();
            reader.read();

            //check that there are five card boxes in the card box manager.
            assertEquals(5, cardBoxManager.getListOfCardBoxes().size());
            //check that there are no cards for each boxes
            //box 1
            CardBox firstBox = cardBoxManager.findCardBoxInCardBoxManager(1);
            assertEquals(0, firstBox.getTableOfCards().size());

            //box2
            CardBox secondBox = cardBoxManager.findCardBoxInCardBoxManager(2);
            assertEquals(0, secondBox.getTableOfCards().size());

            //box3
            CardBox thirdBox = cardBoxManager.findCardBoxInCardBoxManager(3);
            assertEquals(0, thirdBox.getTableOfCards().size());

            //box4
            CardBox fourthBox = cardBoxManager.findCardBoxInCardBoxManager(4);
            assertEquals(0, fourthBox.getTableOfCards().size());

            //box5
            CardBox fifthBox = cardBoxManager.findCardBoxInCardBoxManager(5);
            assertEquals(0, fifthBox.getTableOfCards().size());
            //pass
        } catch (IOException e) {
            System.out.println("Unable to read from file" );
            fail("Unable to read from file");
        } catch (JSONException e) {
            System.out.println("There is nothing to read or incorrect formatting");
            fail("There is nothing to read or incorrect formatting");
        } catch (ParseException e) {
            System.out.println("Incorrect Date Formatting");
            fail("Incorrect Date Formatting");
        }

    }

    //test when the file has some cards
    @Test
    public void testReadNonEmptySavedCards() {
        CardBoxManager cardBoxManager = new CardBoxManager();
        //JsonReader Constructor
        JsonReader reader = new JsonReader("./data/testReaderNonEmptySavedCards.json", cardBoxManager );

        try {
//            CardBoxManager loadedCardBoxManager = reader.read();
            reader.read();

            //check that there are five card boxes in the card box manager.
            assertEquals(5, cardBoxManager.getListOfCardBoxes().size());

            //check that there are no cards for each boxes
            //box 1
            CardBox firstBox = cardBoxManager.findCardBoxInCardBoxManager(1);
            assertEquals(1, firstBox.getTableOfCards().size());

            //box2
            CardBox secondBox = cardBoxManager.findCardBoxInCardBoxManager(2);
            assertEquals(5, secondBox.getTableOfCards().size());

            //box3
            CardBox thirdBox = cardBoxManager.findCardBoxInCardBoxManager(3);
            assertEquals(3, thirdBox.getTableOfCards().size());

            //box4
            CardBox fourthBox = cardBoxManager.findCardBoxInCardBoxManager(4);
            assertEquals(0, fourthBox.getTableOfCards().size());

            //box5
            CardBox fifthBox = cardBoxManager.findCardBoxInCardBoxManager(5);
            assertEquals(0, fifthBox.getTableOfCards().size());
            //pass
        } catch (IOException e) {
            System.out.println("Unable to read from file" );
            fail("Unable to read from file");
        } catch (JSONException e) {
            System.out.println("There is nothing to read or incorrect formatting");
            fail("There is nothing to read or incorrect formatting");
        } catch (ParseException e) {
            System.out.println("Incorrect Date Formatting");
            fail("Incorrect Date Formatting");
        }

    }





}
