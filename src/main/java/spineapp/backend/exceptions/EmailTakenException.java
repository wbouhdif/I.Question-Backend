package spineapp.backend.exceptions;

public class EmailTakenException extends Exception {

    private static String message = "Email address is already in use.";

    public EmailTakenException() {
        super(message);
    }

}
