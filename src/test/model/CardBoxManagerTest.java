package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CardBoxManagerTest {

    @Test
    public void testConstructor() {
        CardBoxManager cardBoxManagerObj = new CardBoxManager();

        CardBox cardBoxOne = cardBoxManagerObj.getListOfCardBoxes().get(0);
        CardBox cardBoxOneExpected = new CardBox(1, 0);
        assertEquals( cardBoxOneExpected.getCardBoxNum(), cardBoxOne.getCardBoxNum()  );

        CardBox cardBoxTwo = cardBoxManagerObj.getListOfCardBoxes().get(1);
        CardBox cardBoxTwoExpected = new CardBox(2, 20);
        assertEquals( cardBoxTwoExpected.getCardBoxNum(), cardBoxTwo.getCardBoxNum()  );

        CardBox cardBoxThree = cardBoxManagerObj.getListOfCardBoxes().get(2);
        CardBox cardBoxThreeExpected = new CardBox(3, 40);
        assertEquals( cardBoxThreeExpected.getCardBoxNum(), cardBoxThree.getCardBoxNum()  );

        CardBox cardBoxFour = cardBoxManagerObj.getListOfCardBoxes().get(3);
        CardBox cardBoxFourExpected = new CardBox(4, 80);
        assertEquals( cardBoxFourExpected.getCardBoxNum(), cardBoxFour.getCardBoxNum()  );

        CardBox cardBoxFive = cardBoxManagerObj.getListOfCardBoxes().get(4);
        CardBox cardBoxFiveExpected= new CardBox(5, 160);
        assertEquals( cardBoxFiveExpected.getCardBoxNum(), cardBoxFive.getCardBoxNum()  );



    }


    @Test
    public void testFindCardBoxInCardBoxManagerValidCardBoxNumber() {
        CardBoxManager cardBoxManagerObj = new CardBoxManager();
        CardBox expectedCardBoxOneFound = cardBoxManagerObj.getListOfCardBoxes().get(0);
        CardBox actualCardBoxOneFound = cardBoxManagerObj.findCardBoxInCardBoxManager(1);
        assertEquals( expectedCardBoxOneFound, actualCardBoxOneFound);

        CardBox expectedCardBoxTwoFound = cardBoxManagerObj.getListOfCardBoxes().get(1);
        CardBox actualCardBoxTwoFound = cardBoxManagerObj.findCardBoxInCardBoxManager(2);
        assertEquals( expectedCardBoxTwoFound, actualCardBoxTwoFound);

        CardBox expectedCardBoxThreeFound = cardBoxManagerObj.getListOfCardBoxes().get(2);
        CardBox actualCardBoxThreeFound = cardBoxManagerObj.findCardBoxInCardBoxManager(3);
        assertEquals( expectedCardBoxThreeFound, actualCardBoxThreeFound);

        CardBox expectedCardBoxFourFound = cardBoxManagerObj.getListOfCardBoxes().get(3);
        CardBox actualCardBoxFourFound = cardBoxManagerObj.findCardBoxInCardBoxManager(4);
        assertEquals( expectedCardBoxFourFound, actualCardBoxFourFound);

        CardBox expectedCardBoxFiveFound = cardBoxManagerObj.getListOfCardBoxes().get(4);
        CardBox actualCardBoxFiveFound = cardBoxManagerObj.findCardBoxInCardBoxManager(5);
        assertEquals( expectedCardBoxFiveFound, actualCardBoxFiveFound);


    }


    @Test
    public void testFindCardBoxInCardBoxManagerInvalidCardBoxNumber() {
        CardBoxManager cardBoxManagerObj = new CardBoxManager();
        CardBox actualCardBoxOneFound = cardBoxManagerObj.findCardBoxInCardBoxManager(500);
        assertEquals( null, actualCardBoxOneFound);


    }

}
