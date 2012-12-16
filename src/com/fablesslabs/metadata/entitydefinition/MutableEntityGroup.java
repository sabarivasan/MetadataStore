package com.fablesslabs.metadata.entitydefinition;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sabari
 */
class MutableEntityGroup {
    private String name;
    private String label;
    private Set<Entity> entities;

    MutableEntityGroup() {
        entities = new HashSet<Entity>();
    }

    void setName(String name) {
        this.name = name;
    }

    void setLabel(String label) {
        this.label = label;
    }

    void addEntity(Entity entity) {
        entities.add(entity);
    }

    EntityGroup finish() {
        entities = Collections.unmodifiableSet(entities);
        return new EntityGroup() {
            public Set<Entity> entities() {
                return entities;
            }

            public Entity entity(String name) {
                for(Entity entity: entities) {
                    if (entity.name().equals(name)) {
                        return entity;
                    }
                }
                return null;
            }
        };
    }

}
