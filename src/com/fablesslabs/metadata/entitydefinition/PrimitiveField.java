package com.fablesslabs.metadata.entitydefinition;

/**
 * @author sabari
 */
public class PrimitiveField extends AbstractField implements Field {
    private boolean isUnique;

    protected PrimitiveField(String name, String label, DataType dataType, boolean isUnique) {
        super(name, label, dataType);
        this.isUnique = isUnique;
    }

    public boolean isUnique() {
        return isUnique;
    }

    public boolean isMultivalued() {
        return false;
    }

    public boolean isGroup() {
        return false;
    }

    public boolean isComponent() {
        return false;
    }

    public boolean isReference() {
        return false;
    }
}
