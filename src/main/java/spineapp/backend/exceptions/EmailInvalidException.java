package spineapp.backend.exceptions;

public class EmailInvalidException extends Exception {

    public EmailInvalidException(String email) {
        super("Email address: " + email + " is not valid");
    }

}
