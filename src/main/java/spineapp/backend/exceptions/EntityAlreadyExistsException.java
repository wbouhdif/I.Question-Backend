package spineapp.backend.exceptions;

import java.util.UUID;

public class EntityAlreadyExistsException extends Exception {

    public EntityAlreadyExistsException(UUID id) {
        super("Entity with UUID " + id + " already exists");
    }

    public EntityAlreadyExistsException(String text) {
        super("Entity with text " + " already exists.");
    }

}
