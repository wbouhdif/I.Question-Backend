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

    /**
     * Constructs instance of EntityNotFoundException with message.
     * @param name The name of entity in question.
     */
    public EntityNotFoundException(String name) {
        super("Entity with name " + name + " could not be found.");
    }

}
