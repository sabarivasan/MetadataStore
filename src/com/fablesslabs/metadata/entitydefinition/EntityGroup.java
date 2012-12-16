package com.fablesslabs.metadata.entitydefinition;

import java.util.Set;

/**
 * @author sabari
 */
public interface EntityGroup {

    static final String NAMESPACE = "com.fl.metadata.entitydefinition";

    Set<Entity> entities();

    Entity entity(String name);
}
