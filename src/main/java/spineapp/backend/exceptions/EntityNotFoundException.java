package spineapp.backend.exceptions;

import java.util.UUID;

public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(UUID id) {
        super("Entity with UUID " + id + " could not be found.");
    }

}
