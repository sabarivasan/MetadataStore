package com.fablesslabs.metadata.entitydefinition;

/**
 * @author sabari
 */
public class ReferenceField extends AbstractField implements Field {
    private String refEntity;
    private boolean isUnique;

    protected ReferenceField(String name, String label, String refEntity, boolean isUnique) {
        super(name, label, DataType.Reference);
        this.refEntity = refEntity;
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
        return true;
    }
}
