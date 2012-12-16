package com.fablesslabs.metadata.entitydefinition;

/**
 * @author sabari
 */
public class EntityParseException extends Exception {

    public EntityParseException(String message) {
        super(message);
    }

    public EntityParseException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
