package ui;

import model.CardBoxManager;

/*
Main class serves the purpose of creating CommandLineInterface type object to start the applicaton.
Hence, there are no more than few lines of code.

 */
public class Main {
    public static void main(String[] args) {

        //Model
        CardBoxManager cardBoxManager = new CardBoxManager();
        //Model Persistence
        Persistence persistObj = new Persistence(cardBoxManager);

        //CLI View and Controller
        CommandLineInterface cli = new CommandLineInterface(persistObj,cardBoxManager);
        cli.mainMenuUI();

        //GUI View and controller

    }
}
