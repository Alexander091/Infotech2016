package com.zoo;

public class Entity {

    private int id;   //id сущности
    private String name;    //имя сущности

    public void setName(String name) {
        this.name = name;
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

}
