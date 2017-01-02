package com.zoo;

import com.annotation.Attribute;

public abstract class Animal extends Entity {

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

    public void setName(String name){
        this.name = name;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public void setLength(double length){
        this.length = length;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setColour(String colour){
        this.colour = colour;
    }

    public double getLength(){
        return length;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public double getWeight(){
        return weight;
    }

    public String getColour(){
        return colour;
    }

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
