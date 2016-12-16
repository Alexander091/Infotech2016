package com.zooshop;

public class Cat extends Animal{

    public Cat (String name, String colour, int age, double length, double weight){
        super(name,colour,age,length,weight);
    }
    public Cat(){}

    @Override
    public void feed(){ //покормить животное
        System.out.println("You feed cat!");
    }

    @Override
    public void playWithAnimal(){ // поиграть с животным
        System.out.println("You play with cat!");
    }
}
