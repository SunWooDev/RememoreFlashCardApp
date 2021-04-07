package exception;


/*
NoCardFoundException is an exception that is thrown
when findCardInCardBox can't find a card or when no card is found using the given inputID

 */
public class NoCardFoundException extends Exception {

    //REQUIRES: X
    //EFFECTS: constructs NoCardFoundException object given exceptionMessage
    public NoCardFoundException(String exceptionMessage) {
        super(exceptionMessage);

    }

}
