package persistence;


import model.Card;
import model.CardBox;
import model.CardBoxManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonReader {

    private String source;
    private CardBoxManager soleCardBoxManager;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source, CardBoxManager inputCardBoxManager) {
        this.soleCardBoxManager = inputCardBoxManager;
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public CardBoxManager read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCardBoxManager(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }


    // EFFECTS: parses workroom from JSON object and returns it
    private CardBoxManager parseCardBoxManager(JSONObject jsonObjectCardBoxManager) {
        //String name = jsonObject.getString("name");
        //WorkRoom wr = new WorkRoom(name); no need to make a new one

        loadCardBoxes(jsonObjectCardBoxManager);
        return soleCardBoxManager;
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void loadCardBoxes(JSONObject jsonObjectCardBoxManager) {
        JSONArray jsonArray = jsonObjectCardBoxManager.getJSONArray("cardBoxes");
        for (Object cardBoxInCardBoxManager : jsonArray) {
            JSONObject jsonCardBoxInCardBoxManager = (JSONObject) cardBoxInCardBoxManager;
            parseCardBox(jsonCardBoxInCardBoxManager);
        }
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private void parseCardBox(JSONObject jsonObjectCardBox) {
        int cardBoxNumber = jsonObjectCardBox.getInt("cardBoxNumber");

        loadCards(cardBoxNumber,jsonObjectCardBox);
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void loadCards(int cardBoxNumber, JSONObject jsonObjectCardBox) {

        JSONArray jsonArray = jsonObjectCardBox.getJSONArray("cards");
        for (Object cardInCardBox : jsonArray) {
            JSONObject jsonCardInCardBox = (JSONObject) cardInCardBox;
            loadCard(cardBoxNumber, jsonCardInCardBox);
        }
    }



    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void loadCard(int cardBoxNumber, JSONObject jsonObject) { //jsonObject made from card
        CardBox loadCurrentCardBox = soleCardBoxManager.findCardBoxInCardBoxManager(cardBoxNumber);

        String backInfo = jsonObject.getString("backInfo");
        int cardID = jsonObject.getInt("cardID");
        int timeUntilTestedAgain = jsonObject.getInt("timeUntilTestedAgain");
        String frontInfo = jsonObject.getString("frontInfo");

//        Category category = Category.valueOf(jsonObject.getString("category"));
//        Thingy thingy = new Thingy(name, category);
        Card loadCard = new Card(frontInfo,backInfo,timeUntilTestedAgain,cardID);
        loadCurrentCardBox.loadCard(loadCard);

    }

}
