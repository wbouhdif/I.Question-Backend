package spineapp.backend.exceptions;

public class EmailTakenException extends Exception {

    private static String message = "Email address is already in use.";

    /**
     * Constructs instance of EmailTakenException with message.
     */
    public EmailTakenException() {
        super(message);
    }

}
