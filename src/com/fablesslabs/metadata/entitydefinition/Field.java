package com.fablesslabs.metadata.entitydefinition;

/**
 * @author sabari
 */
public interface Field {

    String name();

    String label();

    DataType dataType();

    boolean isUnique();

    boolean isMultivalued();

    boolean isGroup();

    boolean isComponent();

    boolean isReference();
}
