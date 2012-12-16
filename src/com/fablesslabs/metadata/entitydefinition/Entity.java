package com.fablesslabs.metadata.entitydefinition;

import java.util.Set;

/**
 * @author sabari
 */
public interface Entity {

    String name();

    String label();

    Field key();

    Set<Field> fields();

    Field field(String name);

    EntityGroup parent();
}
