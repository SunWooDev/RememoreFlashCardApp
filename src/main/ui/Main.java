package ui;

import model.CardBoxManager;
import persistence.Persistence;

/*
Main class serves the purpose of creating CommandLineInterface type object to start the applicaton.
Hence, there are no more than few lines of code.
 */
public class Main {
    public static void main(String[] args) {


        CardBoxManager cardBoxManager = new CardBoxManager();
        Persistence persistObj = new Persistence(cardBoxManager);

        CommandLineInterface cli = new CommandLineInterface(persistObj,cardBoxManager);
        cli.mainMenuUI();

    }
}
