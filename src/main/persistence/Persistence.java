package persistence;

import model.CardBoxManager;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Persistence {

    private CardBoxManager soleCardBoxManager;
    private JsonReader jsonReaderObj;
    private JsonWriter jsonWriterObj;
    private static final String JSON_STORE = "./data/savedCards.json";


    public Persistence(CardBoxManager inputSoleCardBoxManager) {
        soleCardBoxManager = inputSoleCardBoxManager;
        jsonWriterObj = new JsonWriter(JSON_STORE);
        jsonReaderObj = new JsonReader(JSON_STORE,soleCardBoxManager);

    }

    public void saveCards() {
        try {
            jsonWriterObj.open();
            jsonWriterObj.write(soleCardBoxManager);
            jsonWriterObj.close();
            System.out.println("All Cards saved to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }

    }



    // MODIFIES: this
    // EFFECTS: loads workroom from file
    public void loadCards() {
        try {
            soleCardBoxManager = jsonReaderObj.read();
            System.out.println("Loaded from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }




}
