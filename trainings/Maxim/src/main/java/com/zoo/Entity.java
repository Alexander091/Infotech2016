package com.zoo;

import com.annotation.Attribute;

public class Entity {

    private int id;   //id сущности
    private String name;    //имя сущности
    @Attribute(7)
    private int type;//тип сущности

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }
}
