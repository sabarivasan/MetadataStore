package com.fablesslabs.metadata.entitydefinition;

/**
 * @author sabari
 */
abstract class AbstractField implements Field {
    protected String name;
    protected String label;
    protected DataType dataType;

    protected AbstractField(String name, String label, DataType dataType) {
        this.name = name;
        this.label = label;
        this.dataType = dataType;
    }

    public String name() {
        return name;
    }

    public String label() {
        return label;
    }

    public DataType dataType() {
        return dataType;
    }
}
