package com.fablesslabs.metadata.entitydefinition;

import java.util.Set;

/**
 * @author sabari
 */
class MutableEntity {

    private String name;
    private String label;
    private DataType keyDataType;
    private Set<Field> fields;
    private Set<Group> groups;

    void setName(String name) {
        this.name = name;
    }

    void setLabel(String label) {
        this.label = label;
    }

    void setKeyDataType(String dataType) throws EntityParseException {
        if ("string".equals(dataType)) {
            keyDataType = DataType.String;
        } else if ("int".equals(dataType)) {
            keyDataType = DataType.Integer;
        } else if ("real".equals(dataType)) {
            keyDataType = DataType.Real;
        } else if ("timestamp".equals(dataType)) {
            keyDataType = DataType.Timestamp;
        } else {
            throw new EntityParseException("Key has to be of one of the following types:string, int, real or timestamp");
        }
    }

    void addPrimitiveField(String name, String type) {

    }

}
