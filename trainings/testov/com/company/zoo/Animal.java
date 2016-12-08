package com.company.zoo;

/**
 * Created by bote0814 on 08.12.2016.
 */
public abstract class Animal {

    protected Animal(Color color, int age, int price){
        this.color = color;
        this.age = age;
        this.price = price;
    }


    public abstract String voice();

    public enum Color{
        Black,
        White,
        Red
    }

    private int age;
    private int price;
    private Color color;


    public int getAge(){
        return age;
    }

    public int getPrice(){
        return price;
    }

    public Color getColor(){
        return color;
    }
}
