package spineapp.backend.exceptions;

import java.util.UUID;

public class EntityNotFoundException extends Exception {

    /**
     * Constructs instance of EntityNotFoundException with message.
     * @param id The id of the entity in question.
     */
    public EntityNotFoundException(UUID id) {
        super("Entity with UUID " + id + " could not be found.");
    }

}
