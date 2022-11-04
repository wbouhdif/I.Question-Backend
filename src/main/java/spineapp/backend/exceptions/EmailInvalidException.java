package spineapp.backend.exceptions;

public class EmailInvalidException extends Exception {

    /**
     * Constructs instance of EmailInvalidException with message.
     * @param email The invalid email in question.
     */
    public EmailInvalidException(String email) {
        super("Email address: " + email + " is not valid");
    }

}
