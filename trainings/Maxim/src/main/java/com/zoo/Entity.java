package com.zoo;

public class Entity {

    /* Список параметров сущности
    *  которые указаны в таблице
    *  objects
    */
    private int objectId;
    private long parentId;
    private long objectTypeId;
    private String name;

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

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                '}';
    }

}
