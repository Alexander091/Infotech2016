package com.zoo;

import com.annotation.Attribute;

public abstract class Animal extends Entity {

    /*
    * Список параметров животных
    */

    @Attribute(1)
    private double weight; //вес
    @Attribute(2)
    private double length; //длина
    @Attribute(3)
    private int age;//возраст
    @Attribute(4)
    private String name;//клички животных
    @Attribute(5)
    private String colour;//цвет
    private String kind;//род

    /*
    * Сеттеры и геттеры
    */

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    /*
    * Методы для кормления и игры с животным
    */

    public void feed(){ //покормить животное
        System.out.println("You feed animal!");
    }

    public void playWithAnimal(){ // поиграть с животным
        System.out.println("You play with animal!");
    }

    @Override
    public String toString(){
        return
                "Name "+this.name +
                        " colour " + this.colour +
                        " age " + this.age +
                        " length "  + this.length +
                        " weight " + this.weight;

    }

}
