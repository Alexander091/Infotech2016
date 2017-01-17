package com.zoo;

public class Entity {

    /* Список параметров сущности
    *  которые указаны в таблице
    *  objects
    */
    private long objectId = 0;
    private long parentId;
    private long objectTypeId;
    private String nameType;

    /*
    * Список параметров сущности
    * котроые указаны в таблице
    * params
    */

    private long attrId;
    //objectId уже указан, он есть в таблице objects
    private String value;

    /* Сеттеры и геттеры
    *  для наших параметров
    */

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(long objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public long getAttrId() {
        return attrId;
    }

    public void setAttrId(long attrId) {
        this.attrId = attrId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /*
    * переопределяем toString
    */

    @Override
    public String toString() {
        return "Entity{" +
                "objectId=" + objectId +
                ", parentId=" + parentId +
                ", objectTypeId=" + objectTypeId +
                ", name='" + nameType + '\'' +
                '}';
    }

}
