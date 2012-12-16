package com.fablesslabs.metadata.entitydefinition;

import java.util.Set;

/**
 * @author sabari
 */
public interface Group extends Field {

    Set<Field> fields();

    Field field(String name);

    Set<Group> subGroups();

    Group subGroup(String name);
}
